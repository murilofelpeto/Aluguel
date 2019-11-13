package br.com.murilo.aluguel.dto.response;

import java.io.Serializable;

import br.com.murilo.aluguel.model.Fiador;
import lombok.Getter;

@Getter
public class FiadorCasaResponse implements Serializable {

	private static final long serialVersionUID = -5221225316948879356L;
	
	private String nome;
	private String tipoDocumento;
	private Long documento;
	
	public FiadorCasaResponse(Fiador fiador) {
		this.nome = fiador.getNome();
		this.tipoDocumento = fiador.getTipoDocumento();
		this.documento = fiador.getDocumento();
	}

}
