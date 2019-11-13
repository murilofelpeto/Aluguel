package br.com.murilo.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.aluguel.converter.DozerConverter;
import br.com.murilo.aluguel.dto.response.InquilinoVO;
import br.com.murilo.aluguel.exception.ResourceNotFoundException;
import br.com.murilo.aluguel.model.Fiador;
import br.com.murilo.aluguel.model.Inquilino;
import br.com.murilo.aluguel.repository.InquilinoRepository;

@Service
public class InquilinoService {

	private static final String MESSAGE = "Inquilino não encontrado!";
	
	@Autowired
	private InquilinoRepository repository;
	
	public InquilinoVO findById(Long id) {
		Inquilino inquilino = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
		return DozerConverter.parseObject(inquilino, InquilinoVO.class);
	}
	
	public InquilinoVO findByCpf(Long cpf) {
		Inquilino inquilino = repository.findByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
		return DozerConverter.parseObject(inquilino, InquilinoVO.class);
	}
	
	public InquilinoVO salvarInquilino(InquilinoVO vo) {
		Inquilino inquilino = DozerConverter.parseObject(vo, Inquilino.class);
		return DozerConverter.parseObject(repository.save(inquilino), InquilinoVO.class);
	}
	
	public InquilinoVO updateInquilino(InquilinoVO vo) {
		Inquilino inquilino = repository.findById(vo.getKey()).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
		inquilino.setCpf(vo.getCpf());
		inquilino.setEstadoCivil(vo.getEstadoCivil());
		inquilino.setFiadores(DozerConverter.parseListObjects(vo.getFiadores(), Fiador.class));
		inquilino.setNacionalidade(vo.getNacionalidade());
		inquilino.setNome(vo.getNome());
		inquilino.setProfissao(vo.getProfissao());
		inquilino.setRenda(vo.getRenda());
		inquilino.setRg(vo.getRg());
		return DozerConverter.parseObject(repository.save(inquilino), InquilinoVO.class);
	}
	
	public void deleteInquilino(Long id) {
		Inquilino inquilino = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
		repository.delete(inquilino);
	}
}
