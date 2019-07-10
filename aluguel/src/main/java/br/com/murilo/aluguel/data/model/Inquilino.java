package br.com.murilo.aluguel.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
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

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((fiadores == null) ? 0 : fiadores.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result + ((renda == null) ? 0 : renda.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inquilino other = (Inquilino) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (estadoCivil != other.estadoCivil)
			return false;
		if (fiadores == null) {
			if (other.fiadores != null)
				return false;
		} else if (!fiadores.equals(other.fiadores))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nacionalidade == null) {
			if (other.nacionalidade != null)
				return false;
		} else if (!nacionalidade.equals(other.nacionalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (profissao == null) {
			if (other.profissao != null)
				return false;
		} else if (!profissao.equals(other.profissao))
			return false;
		if (renda == null) {
			if (other.renda != null)
				return false;
		} else if (!renda.equals(other.renda))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}
}
