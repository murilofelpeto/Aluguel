package br.com.murilo.aluguel.model.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.murilo.aluguel.model.Casa;
import br.com.murilo.aluguel.model.Endereco;
import br.com.murilo.aluguel.model.Inquilino;
import br.com.murilo.aluguel.model.Proprietario;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CasaBuilder {
	
	private Long id;
	private String tipoCasa;
	private BigDecimal valorAluguel;
	private BigDecimal valorIPTU;
	private LocalDate dataVencimento;
	private Endereco endereco;
	private Proprietario proprietario;
	private Inquilino inquilino;

	public CasaBuilder comID(Long id) {
		this.id = id;
		return this;
	}
	
	public CasaBuilder qualTipoCasa(String tipoCasa) {
		this.tipoCasa = tipoCasa;
		return this;
	}
	
	public CasaBuilder qualValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
		return this;
	}
	
	public CasaBuilder qualValorIPTU(BigDecimal valorIptu) {
		this.valorIPTU = valorIptu;
		return this;
	}
	
	public CasaBuilder quandoVenceAluguel(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
		return this;
	}
	
	public CasaBuilder qualEndereco(Endereco endereco) {
		this.endereco = endereco;
		return this;
	}
	
	public CasaBuilder qualProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
		return this;
	}
	
	public CasaBuilder qualInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
		return this;
	}
	
	public Casa build() {
		return new Casa(id, tipoCasa, valorAluguel, valorIPTU, dataVencimento, endereco, proprietario, inquilino);
	}
}
