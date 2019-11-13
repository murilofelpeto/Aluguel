package br.com.murilo.aluguel.types;

import java.util.HashMap;
import java.util.Map;

public enum EstadoCivil {

	SOLTEIRO("Solteiro"),
	CASADO("Casado"),
	VIUVO("Viuvo"),
	DIVORCIADO("Divorciado");
	
	private String estadoCivil;

	private static final Map<String, EstadoCivil> byEC = new HashMap<>();

	static {
		for (EstadoCivil p : values()) {
			byEC.put(p.estadoCivil, p);
		}
	}

	
	EstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
}
