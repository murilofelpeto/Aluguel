package br.com.murilo.aluguel.data.model;

public enum TipoDocumento {

	CPF("CPF"),
	CNPJ("CNPJ");
	
	private String tipoDocumento;

	private TipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
}
