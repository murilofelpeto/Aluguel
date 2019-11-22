package br.com.murilo.aluguel.dto.response;

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
	
	public ProprietarioResponse(Proprietario proprietario) {
		this.id = proprietario.getId();
		this.nome = proprietario.getNome();
		this.rg = proprietario.getRg();
		this.cpf = proprietario.getCpf();
		this.estadoCivil = proprietario.getEstadoCivil().getEstadoCivil();
		this.nacionalidade = proprietario.getNacionalidade();
	}
}
