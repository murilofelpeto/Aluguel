package br.com.murilo.aluguel.data.model;

public enum EstadoCivil {

	SOLTEIRO("Solteiro"),
	CASADO("Casado"),
	VIUVO("Viuvo"),
	DIVORCIADO("Divorciado");
	
	private String estadoCivil;

	EstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
}
