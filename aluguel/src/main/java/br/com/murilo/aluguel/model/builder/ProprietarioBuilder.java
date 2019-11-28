package br.com.murilo.aluguel.model.builder;

import java.util.List;

import br.com.murilo.aluguel.model.Casa;
import br.com.murilo.aluguel.model.Proprietario;
import br.com.murilo.aluguel.types.EstadoCivil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProprietarioBuilder {

	private Long id;
	private String nome;
	private Long rg;
	private Long cpf;
	private EstadoCivil estadoCivil;
	private String nacionalidade;
	private List<Casa> casas;
	
	public ProprietarioBuilder comID(Long id) {
		this.id = id;
		return this;
	}
	
	public ProprietarioBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public ProprietarioBuilder comRG(Long rg) {
		this.rg = rg;
		return this;
	}
	
	public ProprietarioBuilder comCPF(Long cpf) {
		this.cpf = cpf;
		return this;
	}
	
	public ProprietarioBuilder qualEstadoCivil(String estadoCivil) {
		this.estadoCivil = EstadoCivil.qualEstadoCivil(estadoCivil);
		return this;
	}
	
	public ProprietarioBuilder qualNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
		return this;
	}
	
	public ProprietarioBuilder quaisCasas(List<Casa> casas) {
		this.casas = casas;
		return this;
	}
	
	public Proprietario build() {
		return new Proprietario(id, nome, rg, cpf, estadoCivil, nacionalidade, casas);
	}
}
