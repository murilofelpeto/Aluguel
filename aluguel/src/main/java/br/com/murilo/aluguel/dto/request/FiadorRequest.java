package br.com.murilo.aluguel.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class FiadorRequest implements Serializable {

	private static final long serialVersionUID = -8800252275287764324L;

	private Long id;
	private String nome;
	private Long rg;
	private String tipoDocumento;
	private Long documento;
	private BigDecimal renda;
}
