package br.com.murilo.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.aluguel.data.model.Proprietario;
import br.com.murilo.aluguel.exception.ResourceNotFoundException;
import br.com.murilo.aluguel.repository.ProprietarioRepository;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository repository;
	
	private final String MESSAGE = "Proprietario não encontrado!";
	
	public Proprietario findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
	}
	
	public List<Proprietario> findAll(){
		return repository.findAll();
	}
	
	public Proprietario create(Proprietario proprietario) {
		return repository.save(proprietario);
	}
}
