package br.com.murilo.aluguel.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.murilo.aluguel.dto.request.FiadorRequest;
import br.com.murilo.aluguel.dto.request.InquilinoRequest;
import br.com.murilo.aluguel.dto.response.InquilinoResponse;
import br.com.murilo.aluguel.model.Fiador;
import br.com.murilo.aluguel.model.Inquilino;
import br.com.murilo.aluguel.model.builder.FiadorBuilder;
import br.com.murilo.aluguel.model.builder.InquilinoBuilder;
import br.com.murilo.aluguel.service.InquilinoService;

@Component
public class InquilinoFacade {

	@Autowired
	private InquilinoService inquilinoService;

	public InquilinoResponse findById(Long id) {
		return new InquilinoResponse(inquilinoService.findById(id));
	}

	public InquilinoResponse findByCpf(Long cpf) {
		return new InquilinoResponse(inquilinoService.findByCpf(cpf));
	}

	public InquilinoResponse salvarInquilino(InquilinoRequest inquilinoRequest) {
		Inquilino inquilino = buildInquilino(inquilinoRequest);
		return new InquilinoResponse(inquilinoService.salvarInquilino(inquilino));
	}

	public InquilinoResponse updateInquilino(Long id, InquilinoRequest inquilinoRequest) {
		Inquilino inquilino = buildInquilino(inquilinoRequest);
		return new InquilinoResponse(inquilinoService.updateInquilino(id, inquilino));
	}
	

	public void deleteInquilino(Long id) {
		inquilinoService.deleteInquilino(id);		
	}

	private Inquilino buildInquilino(InquilinoRequest inquilino) {
		return new InquilinoBuilder()
				.comID(inquilino.getId())
				.quaisOsFiadores(buildFiador(inquilino.getFiadores()))
				.qualCPF(inquilino.getCpf())
				.qualEstadoCivil(inquilino.getEstadoCivil())
				.qualNacionalidade(inquilino.getNacionalidade())
				.qualNome(inquilino.getNome())
				.qualProfissao(inquilino.getProfissao())
				.qualRenda(inquilino.getRenda())
				.qualRG(inquilino.getRg())
				.build();
	}

	private List<Fiador> buildFiador(List<FiadorRequest> fiadoresRequest) {
		return fiadoresRequest.stream().map(f -> {
			return new FiadorBuilder()
			.comID(f.getId())
			.qualDocumento(f.getDocumento())
			.qualNome(f.getNome())
			.qualRenda(f.getRenda())
			.qualRG(f.getRg())
			.qualTipoDoDocumento(f.getTipoDocumento())
			.build();
			})
				.collect(Collectors.toList()); 
	}

}
