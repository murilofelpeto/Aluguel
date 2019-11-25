package br.com.murilo.aluguel.model;

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

import br.com.murilo.aluguel.types.EstadoCivil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "inquilino")
@AllArgsConstructor
@NoArgsConstructor
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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "inquilino_fiador", joinColumns = { @JoinColumn(name = "id_inquilino") }, inverseJoinColumns = {
			@JoinColumn(name = "id_fiador") })
	private List<Fiador> fiadores;
	
	public String getEstadoCivil() {
		return this.estadoCivil.getEstadoCivil();
	}
}
