package br.com.murilo.aluguel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.aluguel.converter.DozerConverter;
import br.com.murilo.aluguel.data.model.Casa;
import br.com.murilo.aluguel.data.model.Endereco;
import br.com.murilo.aluguel.data.model.Inquilino;
import br.com.murilo.aluguel.data.model.Proprietario;
import br.com.murilo.aluguel.data.vo.CasaVO;
import br.com.murilo.aluguel.exception.ResourceNotFoundException;
import br.com.murilo.aluguel.repository.CasaRepository;
import br.com.murilo.aluguel.repository.EnderecoRepository;
import br.com.murilo.aluguel.repository.InquilinoRepository;
import br.com.murilo.aluguel.repository.ProprietarioRepository;

@Service
public class CasaService {

	@Autowired
	private CasaRepository casaRepository;

	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	@Autowired
	private InquilinoRepository inquilinoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	private final String PROPRIETARIO_MESSAGE = "Proprietario não encontrado!";
	private final String CASA_MESSAGE = "Casa não encontrada!";

	public List<CasaVO> findCasaByProprietario(Long id) {
		proprietarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(PROPRIETARIO_MESSAGE));
		List<Casa> casas = casaRepository.findByProprietarioId(id);
		return DozerConverter.parseListObjects(casas, CasaVO.class);
	}
	
	public CasaVO findByCEP(Integer cep) {
		Optional<Casa> casa = casaRepository.findByEnderecoCep(cep);
		if(casa.isPresent()) {
			return DozerConverter.parseObject(casa.get(), CasaVO.class);
		}
		throw new ResourceNotFoundException(CASA_MESSAGE);
	}
	
	public CasaVO salvarCasa(Long proprietarioID, CasaVO vo) {
		Proprietario proprietario = proprietarioRepository.findById(proprietarioID).orElseThrow(() -> new ResourceNotFoundException(PROPRIETARIO_MESSAGE));
		vo.setProprietario(proprietario);
		
		if(inquilinoRepository.findByCpf(vo.getInquilino().getCpf()).isPresent()) {
			Inquilino existingInquilino = inquilinoRepository.findByCpf(vo.getInquilino().getCpf()).orElseThrow(() -> new ResourceNotFoundException("Inquilino não encontrado!"));
			vo.setInquilino(existingInquilino);
		}
		
		//TODO tratar o CEP com inicio 0. Jackson ta quebrando com leading 0
		//TODO tratar os erros para quando endereco ou inquilino estiverem cadastrados em outro lugar
		Integer cep = vo.getEndereco().getCep();
		String logradouro = vo.getEndereco().getLogradouro();
		Integer numero = vo.getEndereco().getNumero();
		if(enderecoRepository.findByCepAndLogradouroAndNumero(cep, logradouro, numero).isPresent()) {
			Endereco existingEndereco = enderecoRepository.findByCepAndLogradouroAndNumero(cep, logradouro, numero).get();
			vo.setEndereco(existingEndereco);
		}
		
		Casa newCasa = casaRepository.save(DozerConverter.parseObject(vo, Casa.class));
		return DozerConverter.parseObject(newCasa, CasaVO.class);
	}
	
	public CasaVO atualizarCasa(Long proprietarioID, CasaVO vo) {
		Proprietario proprietario = proprietarioRepository.findById(proprietarioID).orElseThrow(() -> new ResourceNotFoundException(PROPRIETARIO_MESSAGE));
		Casa casa = casaRepository.findById(vo.getKey()).orElseThrow(() -> new ResourceNotFoundException(CASA_MESSAGE));
		casa.setDataVencimento(vo.getDataVencimento());
		casa.setEndereco(vo.getEndereco());
		casa.setInquilino(vo.getInquilino());
		casa.setProprietario(proprietario);
		casa.setValorAluguel(vo.getValorAluguel());
		casa.setValorIPTU(vo.getValorIPTU());
		return DozerConverter.parseObject(casaRepository.save(casa), CasaVO.class);
	}
	
	public void deleteCasa(Long id) {
		Casa casa = casaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(CASA_MESSAGE));
		casaRepository.delete(casa);
	}
}
