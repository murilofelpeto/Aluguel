package br.com.murilo.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.aluguel.exception.ResourceNotFoundException;
import br.com.murilo.aluguel.model.Proprietario;
import br.com.murilo.aluguel.repository.ProprietarioRepository;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	private final String MESSAGE = "Proprietario não encontrado!";
	
	public List<Proprietario> findAll(){
		return proprietarioRepository.findAll();
	}
	
	public Proprietario findById(Long id) {
		return proprietarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
	}
	
	public List<Proprietario> findByName(String name) {
		return proprietarioRepository.findByNomeContaining(name);
	}
	
	public Proprietario create(Proprietario proprietario) {
		return proprietarioRepository.save(proprietario);
	}
	
	public Proprietario update(Long id, Proprietario proprietario) {
		if(proprietarioExist(id)) {
			proprietario.setId(id);
			return proprietarioRepository.save(proprietario);
		}
		throw new ResourceNotFoundException(MESSAGE);
	}

	public void delete(Long id) {
		//TODO Delete on cascade with Casa
		Proprietario proprietario = proprietarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
		proprietarioRepository.delete(proprietario);
	}
	
	private boolean proprietarioExist(Long id) {
		return proprietarioRepository.findById(id).isPresent();
	}
}
