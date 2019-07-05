package br.com.murilo.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.aluguel.converter.DozerConverter;
import br.com.murilo.aluguel.data.model.Proprietario;
import br.com.murilo.aluguel.data.vo.ProprietarioVO;
import br.com.murilo.aluguel.exception.ResourceNotFoundException;
import br.com.murilo.aluguel.repository.ProprietarioRepository;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository repository;
	
	private final String MESSAGE = "Proprietario não encontrado!";
	
	public ProprietarioVO findById(Long id) {
		Proprietario proprietario = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE));
		return DozerConverter.parseObject(proprietario, ProprietarioVO.class);
	}
	
	public List<ProprietarioVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), ProprietarioVO.class);
	}
	
	public ProprietarioVO create(ProprietarioVO vo) {
		Proprietario proprietario = DozerConverter.parseObject(vo, Proprietario.class);
		return DozerConverter.parseObject(repository.save(proprietario), ProprietarioVO.class);
	}
}
