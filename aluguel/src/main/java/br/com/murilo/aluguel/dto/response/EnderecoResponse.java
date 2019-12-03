package br.com.murilo.aluguel.dto.response;

import br.com.murilo.aluguel.model.Endereco;
import lombok.Getter;

@Getter
public class EnderecoResponse {

	private Long id;
	private String enderecoCompleto;
	private String cep;
	private String estado;
	private String cidade;
	
	public EnderecoResponse(Endereco endereco) {
		this.id = endereco.getId();
		this.enderecoCompleto = endereco.getEnderecoCompleto();
		this.cep = endereco.getCep();
		this.estado = endereco.getEstado();
		this.cidade = endereco.getCidade();
	}
}
