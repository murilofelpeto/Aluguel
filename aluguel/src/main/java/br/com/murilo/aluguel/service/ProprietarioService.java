package br.com.murilo.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.aluguel.converter.DozerConverter;
import br.com.murilo.aluguel.dto.response.ProprietarioVO;
import br.com.murilo.aluguel.exception.ResourceNotFoundException;
import br.com.murilo.aluguel.model.Proprietario;
import br.com.murilo.aluguel.repository.ProprietarioRepository;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository repository;
	
	private final String MESSAGE = "Proprietario não encontrado!";
	
	public List<Proprietario> findAll(){
		return repository.findAll();
	}
	
	public Proprietario findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
	}
	
	public List<Proprietario> findByName(String name) {
		return repository.findByNomeContaining(name);
	}
	
	public Proprietario create(Proprietario proprietario) {
		return repository.save(proprietario);
	}
	
	public ProprietarioVO update(ProprietarioVO vo) {
		Proprietario proprietario = repository.findById(vo.getKey()).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
		proprietario.setCpf(vo.getCpf());
		proprietario.setEstadoCivil(vo.getEstadoCivil());
		proprietario.setNacionalidade(vo.getNacionalidade());
		proprietario.setNome(vo.getNome());
		proprietario.setRg(vo.getRg());
		return DozerConverter.parseObject(repository.save(proprietario), ProprietarioVO.class);
	}
	
	public void delete(Long id) {
		//TODO Delete on cascade with Casa
		Proprietario proprietario = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
		repository.delete(proprietario);
	}
}
