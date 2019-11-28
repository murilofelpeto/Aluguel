package br.com.murilo.aluguel.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.murilo.aluguel.model.Casa;
import br.com.murilo.aluguel.model.Proprietario;
import lombok.Getter;

@Getter
public class ProprietarioResponse {

	private Long id;
	private String nome;
	private Long rg;
	private Long cpf;
	private String estadoCivil;
	private String nacionalidade;
	private List<CasaProprietarioResponse> casas;
	
	public ProprietarioResponse(Proprietario proprietario) {
		this.id = proprietario.getId();
		this.nome = proprietario.getNome();
		this.rg = proprietario.getRg();
		this.cpf = proprietario.getCpf();
		this.estadoCivil = proprietario.getEstadoCivil().getEstadoCivil();
		this.nacionalidade = proprietario.getNacionalidade();
		
		if(proprietario.getCasas() != null) {
			this.casas = getCasa(proprietario.getCasas());			
		}
	}

	private List<CasaProprietarioResponse> getCasa(List<Casa> casas) {
		return casas.stream()
				.map(casa -> new CasaProprietarioResponse(casa))
				.collect(Collectors.toList());
	}
}
