package br.com.murilo.aluguel.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class InquilinoRequest implements Serializable {

	private static final long serialVersionUID = -4725402799549890216L;
	
	private Long id;
	private String nome;
	private Long rg;
	private Long cpf;
	private String estadoCivil;
	private String nacionalidade;
	private String profissao;
	private BigDecimal renda;
	private List<FiadorRequest> fiadores;
}
