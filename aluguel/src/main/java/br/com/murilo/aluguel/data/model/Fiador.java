package br.com.murilo.aluguel.data.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fiador")
public class Fiador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false, length = 255)
	private String nome;

	@Column(name = "rg", nullable = true, columnDefinition = "bigint(14)")
	private Long rg;

	@Column(name = "tipo_documento", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipoDocumento;

	@Column(name = "documento", unique = true, columnDefinition = "bigint(14)",nullable = false)
	private Long documento;

	@Column(name = "renda", nullable = false)
	private BigDecimal renda;

	public Fiador() {
	}
}
