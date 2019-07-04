package br.com.murilo.aluguel.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "inquilino")
public class Inquilino implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false, length = 180)
	private String nome;

	@Column(name = "rg", nullable = false, columnDefinition = "bigint(14)")
	private Long rg;

	@Column(name = "cpf", unique = true, nullable = false, columnDefinition = "bigint(11)")
	private Long cpf;

	@Column(name = "estado_civil")
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;

	@Column(name = "nacionalidade", nullable = false, length = 80)
	private String nacionalidade;

	@Column(name = "profissao", nullable = false, length = 100)
	private String profissao;

	@Column(name = "renda", nullable = false)
	private BigDecimal renda;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "inquilino_fiador", joinColumns = { @JoinColumn(name = "id_inquilino") }, inverseJoinColumns = {
			@JoinColumn(name = "id_fiador") })
	private List<Fiador> fiadores;

	public Inquilino() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}

	public List<Fiador> getFiadores() {
		return fiadores;
	}

	public void setFiadores(List<Fiador> fiadores) {
		this.fiadores = fiadores;
	}
}
