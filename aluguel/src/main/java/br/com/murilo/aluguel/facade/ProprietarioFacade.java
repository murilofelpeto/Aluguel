package br.com.murilo.aluguel.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.murilo.aluguel.dto.request.ProprietarioRequest;
import br.com.murilo.aluguel.dto.response.ProprietarioResponse;
import br.com.murilo.aluguel.model.Proprietario;
import br.com.murilo.aluguel.model.builder.ProprietarioBuilder;
import br.com.murilo.aluguel.service.ProprietarioService;

@Component
public class ProprietarioFacade {

	@Autowired
	private ProprietarioService proprietarioService;

	public List<ProprietarioResponse> findAll() {
		return proprietarioService.findAll()
				.stream()
				.map(proprietario -> new ProprietarioResponse(proprietario))
				.collect(Collectors.toList());
	}

	public ProprietarioResponse findById(Long id) {
		return new ProprietarioResponse(proprietarioService.findById(id));
	}

	public List<ProprietarioResponse> findByName(String name) {
		return proprietarioService.findByName(name)
				.stream()
				.map(proprietario -> new ProprietarioResponse(proprietario))
				.collect(Collectors.toList());
	}

	public ProprietarioResponse create(ProprietarioRequest proprietarioRequest) {
		Proprietario proprietario = buildProprietario(proprietarioRequest);
		return new ProprietarioResponse(proprietarioService.create(proprietario));
	}

	public ProprietarioResponse update(Long id, ProprietarioRequest proprietarioRequest) {
		Proprietario proprietario = buildProprietario(proprietarioRequest);
		return new ProprietarioResponse(proprietarioService.update(id, proprietario));
	}
	
	public void delete(Long id) {
		proprietarioService.delete(id);		
	}
	
	private Proprietario buildProprietario(ProprietarioRequest proprietario) {
		return new ProprietarioBuilder()
				.comID(proprietario.getId())
				.comCPF(proprietario.getCpf())
				.comNome(proprietario.getNome())
				.comRG(proprietario.getRg())
				.qualEstadoCivil(proprietario.getEstadoCivil())
				.qualNacionalidade(proprietario.getNacionalidade())
				.build();
	}
}
