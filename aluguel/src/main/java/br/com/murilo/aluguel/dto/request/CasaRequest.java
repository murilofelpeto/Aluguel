package br.com.murilo.aluguel.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class CasaRequest implements Serializable {

	private static final long serialVersionUID = -1837253020032142919L;
	
	private Long id;
	private String tipoCasa;
	private BigDecimal valorAluguel;
	private BigDecimal valorIPTU;
	private Date dataVencimento;
	private EnderecoRequest endereco;
	private ProprietarioRequest proprietario;
	private InquilinoRequest inquilino;

}
