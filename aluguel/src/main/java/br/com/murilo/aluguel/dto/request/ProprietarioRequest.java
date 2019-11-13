package br.com.murilo.aluguel.dto.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProprietarioRequest implements Serializable {

	private static final long serialVersionUID = -6229433019423636979L;
	
	private Long id;
	private String nome;
	private Long rg;
	private Long cpf;
	private String estadoCivil;
	private String nacionalidade;

}
