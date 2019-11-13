package br.com.murilo.aluguel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.aluguel.converter.DozerConverter;
import br.com.murilo.aluguel.dto.response.CasaVO;
import br.com.murilo.aluguel.dto.response.EnderecoVO;
import br.com.murilo.aluguel.dto.response.InquilinoVO;
import br.com.murilo.aluguel.dto.response.ProprietarioVO;
import br.com.murilo.aluguel.exception.ExistingResourceException;
import br.com.murilo.aluguel.exception.ResourceNotFoundException;
import br.com.murilo.aluguel.model.Casa;
import br.com.murilo.aluguel.model.Endereco;
import br.com.murilo.aluguel.model.Inquilino;
import br.com.murilo.aluguel.model.Proprietario;
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

	public CasaVO findByCEP(String cep) {
		Optional<Casa> casa = casaRepository.findByEnderecoCep(cep);
		if (casa.isPresent()) {
			return DozerConverter.parseObject(casa.get(), CasaVO.class);
		}
		throw new ResourceNotFoundException(CASA_MESSAGE);
	}

	public CasaVO salvarCasa(Long proprietarioID, CasaVO vo) {
		Proprietario proprietario = proprietarioRepository.findById(proprietarioID)
				.orElseThrow(() -> new ResourceNotFoundException(PROPRIETARIO_MESSAGE));
		vo.setProprietario(DozerConverter.parseObject(proprietario, ProprietarioVO.class));

		if(vo.getInquilino() != null) {
			InquilinoVO existingInquilino = findExistingInquilino(vo.getInquilino());
			if (existingInquilino != null) {
				vo.setInquilino(existingInquilino);
			}			
		}

		EnderecoVO existingEndereco = findingExistingEndereco(vo.getEndereco());
		if (existingEndereco != null) {
			vo.setEndereco(existingEndereco);
		}

		Casa newCasa = casaRepository.save(DozerConverter.parseObject(vo, Casa.class));
		return DozerConverter.parseObject(newCasa, CasaVO.class);
	}

	public CasaVO atualizarCasa(Long proprietarioID, CasaVO vo) {
		Proprietario proprietario = proprietarioRepository.findById(proprietarioID)
				.orElseThrow(() -> new ResourceNotFoundException(PROPRIETARIO_MESSAGE));
		Casa casa = casaRepository.findById(vo.getKey()).orElseThrow(() -> new ResourceNotFoundException(CASA_MESSAGE));
		casa.setDataVencimento(vo.getDataVencimento());
		casa.setEndereco(DozerConverter.parseObject(vo.getEndereco(), Endereco.class));
		casa.setInquilino(DozerConverter.parseObject(vo.getInquilino(), Inquilino.class));
		casa.setProprietario(proprietario);
		casa.setValorAluguel(vo.getValorAluguel());
		casa.setValorIPTU(vo.getValorIPTU());
		return DozerConverter.parseObject(casaRepository.save(casa), CasaVO.class);
	}

	public void deleteCasa(Long id) {
		Casa casa = casaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(CASA_MESSAGE));
		casaRepository.delete(casa);
	}

	private InquilinoVO findExistingInquilino(InquilinoVO inquilino) {
		if (inquilinoRepository.findByCpf(inquilino.getCpf()).isPresent()) {
			Inquilino existingInquilino = inquilinoRepository.findByCpf(inquilino.getCpf())
					.orElseThrow(() -> new ResourceNotFoundException("Inquilino não encontrado!"));

			if (!casaRepository.findByInquilinoId(existingInquilino.getId()).isPresent()) {
				return DozerConverter.parseObject(existingInquilino, InquilinoVO.class);
			} else {
				throw new ExistingResourceException("Inquilino já cadastrado em outra casa");
			}
		}
		return null;
	}

	private EnderecoVO findingExistingEndereco(EnderecoVO endereco) {
		String cep = endereco.getCep();
		String logradouro = endereco.getLogradouro();
		Integer numero = endereco.getNumero();
		if (enderecoRepository.findByCepAndLogradouroAndNumero(cep, logradouro, numero).isPresent()) {
			Endereco existingEndereco = enderecoRepository.findByCepAndLogradouroAndNumero(cep, logradouro, numero)
					.orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado!"));

			if (!casaRepository.findByEnderecoCep(cep).isPresent()) {
				return DozerConverter.parseObject(existingEndereco, EnderecoVO.class);
			} else {
				throw new ExistingResourceException("Já existe uma casa registrada com esse endereço");
			}
		}
		return null;
	}
}
