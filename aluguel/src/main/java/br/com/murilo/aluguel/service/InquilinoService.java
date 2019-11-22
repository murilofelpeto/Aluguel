package br.com.murilo.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.aluguel.exception.ResourceNotFoundException;
import br.com.murilo.aluguel.model.Inquilino;
import br.com.murilo.aluguel.repository.InquilinoRepository;

@Service
public class InquilinoService {

	private static final String MESSAGE = "Inquilino não encontrado!";
	
	@Autowired
	private InquilinoRepository inquilinoRepository;
	
	public Inquilino findById(Long id) {
		return inquilinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
	}
	
	public Inquilino findByCpf(Long cpf) {
		return inquilinoRepository.findByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
	}
	
	public Inquilino salvarInquilino(Inquilino inquilino) {
		return inquilinoRepository.save(inquilino);
	}
	
	public Inquilino updateInquilino(Long id, Inquilino inquilino) {
		if(inquilinoExist(id)) {
			inquilino.setId(id);
			return inquilinoRepository.save(inquilino);
		}
		throw new ResourceNotFoundException(MESSAGE);
	}
	
	public void deleteInquilino(Long id) {
		if(inquilinoExist(id)) {
			inquilinoRepository.deleteById(id);
		}
		throw new ResourceNotFoundException(MESSAGE);
	}

	private boolean inquilinoExist(Long id) {
		return inquilinoRepository.findById(id).isPresent();
	}
}
