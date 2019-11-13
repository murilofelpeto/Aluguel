package br.com.murilo.aluguel.dto.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class EnderecoRequest implements Serializable {

	private static final long serialVersionUID = 5346202072759950706L;

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private Integer numero;
}
