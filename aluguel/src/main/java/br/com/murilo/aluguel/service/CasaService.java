package br.com.murilo.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.aluguel.exception.ResourceNotFoundException;
import br.com.murilo.aluguel.model.Casa;
import br.com.murilo.aluguel.repository.CasaRepository;

@Service
public class CasaService {

	@Autowired
	private CasaRepository casaRepository;

	private final String CASA_MESSAGE = "Casa não encontrada!";
	
	public List<Casa> findCasaByProprietarioName(String name) {
		return casaRepository.findByProprietarioNome(name);
	}

	public List<Casa> findByCEP(String cep) {
		return casaRepository.findByEnderecoCep(cep);
	}

	public Casa salvarCasa(Casa casa) {
		return casaRepository.save(casa);
	}

	public Casa atualizarCasa(Long casaID, Casa casa) {
		if(casaExist(casaID)) {
			casa.setId(casaID);
			casaRepository.save(casa);
		}
		throw new ResourceNotFoundException(CASA_MESSAGE);
	}


	public void deleteCasa(Long id) {
		if(casaExist(id)) {
			casaRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException(CASA_MESSAGE);
		}
	}

	private boolean casaExist(Long casaID) {
		return casaRepository.findById(casaID).isPresent();
	}
}
