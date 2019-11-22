package br.com.murilo.aluguel.model.builder;

import java.math.BigDecimal;

import br.com.murilo.aluguel.model.Fiador;
import br.com.murilo.aluguel.types.TipoDocumento;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FiadorBuilder {

	private Long id;
	private String nome;
	private Long rg;
	private TipoDocumento tipoDocumento;
	private Long documento;
	private BigDecimal renda;
	
	public FiadorBuilder comID(Long id) {
		this.id = id;
		return this;
	}
	
	public FiadorBuilder qualNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public FiadorBuilder qualRG(Long rg) {
		this.rg = rg;
		return this;
	}
	
	public FiadorBuilder qualTipoDoDocumento(String tipoDocumento) {
		this.tipoDocumento = TipoDocumento.qualTipoDocumento(tipoDocumento);
		return this;
	}
	
	public FiadorBuilder qualDocumento(Long documento) {
		this.documento = documento;
		return this;
	}
	
	public FiadorBuilder qualRenda(BigDecimal renda) {
		this.renda = renda;
		return this;
	}
	
	public Fiador build() {
		return new Fiador(id, nome, rg, tipoDocumento, documento, renda);
	}
}
