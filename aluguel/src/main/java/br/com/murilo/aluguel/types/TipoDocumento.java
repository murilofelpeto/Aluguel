package br.com.murilo.aluguel.types;

import java.util.HashMap;
import java.util.Map;

public enum TipoDocumento {

	CPF("CPF"),
	CNPJ("CNPJ");
	
	private String tipoDocumento;

	private static final Map<String, TipoDocumento> byTD = new HashMap<>();

	static {
		for (TipoDocumento p : values()) {
			byTD.put(p.tipoDocumento, p);
		}
	}
	
	TipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public static final TipoDocumento qualTipoDocumento(String valor) {
		return byTD.get(valor);
	}
}
