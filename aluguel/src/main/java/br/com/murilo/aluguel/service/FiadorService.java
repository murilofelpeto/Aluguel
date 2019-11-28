package br.com.murilo.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.aluguel.exception.ResourceNotFoundException;
import br.com.murilo.aluguel.model.Fiador;
import br.com.murilo.aluguel.repository.FiadorRepository;

@Service
public class FiadorService {

	@Autowired
	private FiadorRepository fiadorRepository;
	
	private final String MESSAGE = "Fiador não encontrado!";
	
	public Fiador findByID(Long id) {
		return fiadorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
	}
	
	public Fiador save(Fiador fiador) {
		return fiadorRepository.save(fiador);
	}
}
