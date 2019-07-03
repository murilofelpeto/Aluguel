package br.com.murilo.aluguel.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "aluguel")
public class Aluguel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "data_pagamento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;
	
	@Column(name = "valor_pago", nullable = false)
	private BigDecimal valorPago;
	
	@Column(name = "observacoes", nullable = true)
	private String observacoes;
	
	
	private Casa casa;
}
