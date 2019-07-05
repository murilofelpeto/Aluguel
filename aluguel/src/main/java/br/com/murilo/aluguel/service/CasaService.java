package br.com.murilo.aluguel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.murilo.aluguel.converter.DozerConverter;
import br.com.murilo.aluguel.data.model.Casa;
import br.com.murilo.aluguel.data.vo.CasaVO;
import br.com.murilo.aluguel.repository.CasaRepository;
import br.com.murilo.aluguel.repository.ProprietarioRepository;

@Service
public class CasaService {

	@Autowired
	private CasaRepository casaRepository;

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	public List<CasaVO> findCasaByProprietario(Long id) {
		List<Casa> casas = casaRepository.findByProprietarioId(id);
		return DozerConverter.parseListObjects(casas, CasaVO.class);
	}
}
