package br.com.murilo.aluguel.model.builder;

import java.math.BigDecimal;
import java.util.List;

import br.com.murilo.aluguel.model.Fiador;
import br.com.murilo.aluguel.model.Inquilino;
import br.com.murilo.aluguel.types.EstadoCivil;

public class InquilinoBuilder {

	private Long id;
	private String nome;
	private Long rg;
	private Long cpf;
	private EstadoCivil estadoCivil;
	private String nacionalidade;
	private String profissao;
	private BigDecimal renda;
	private List<Fiador> fiadores;

	public InquilinoBuilder comID(Long id) {
		this.id = id;
		return this;
	}

	public InquilinoBuilder qualNome(String nome) {
		this.nome = nome;
		return this;
	}

	public InquilinoBuilder qualRG(Long rg) {
		this.rg = rg;
		return this;
	}

	public InquilinoBuilder qualCPF(Long cpf) {
		this.cpf = cpf;
		return this;
	}

	public InquilinoBuilder qualEstadoCivil(String estadoCivil) {
		this.estadoCivil = EstadoCivil.qualEstadoCivil(estadoCivil);
		return this;
	}

	public InquilinoBuilder qualNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
		return this;
	}

	public InquilinoBuilder qualProfissao(String profissao) {
		this.profissao = profissao;
		return this;
	}

	public InquilinoBuilder qualRenda(BigDecimal renda) {
		this.renda = renda;
		return this;
	}

	public InquilinoBuilder quaisOsFiadores(List<Fiador> fiadores) {
		this.fiadores = fiadores;
		return this;
	}
	
	public Inquilino build() {
		return new Inquilino(id, nome, rg, cpf, estadoCivil, nacionalidade, profissao, renda, fiadores);
	}
}
