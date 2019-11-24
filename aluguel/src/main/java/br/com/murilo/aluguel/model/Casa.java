package br.com.murilo.aluguel.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "casa")
@AllArgsConstructor
@NoArgsConstructor
public class Casa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "tipo_casa", nullable = false, length = 80)
	private String tipoCasa;

	@Column(name = "valor_aluguel", nullable = false)
	private BigDecimal valorAluguel;

	@Column(name = "valor_iptu", nullable = false)
	private BigDecimal valorIPTU;

	@Column(name = "data_vencimento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
	@JoinColumn(name = "id_endereco", nullable = false)
	private Endereco endereco;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
	@JoinColumn(name = "id_proprietario", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Proprietario proprietario;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_inquilino", nullable = true)
	private Inquilino inquilino;
	
	public String getCep() {
		return this.endereco.getCep();
	}

	public String getEnderecoCompleto() {
		String endereco = this.endereco.getLogradouro() + " - " + this.endereco.getComplemento();
		return endereco;
	}

	public Integer getNumero() {
		return this.endereco.getNumero();
	}

	public String getNomeProprietario() {
		return this.proprietario.getNome();
	}

	public String getNomeInquilino() {
		return this.inquilino.getNome();
	}

	public Long getCpfInquilino() {
		return this.inquilino.getCpf();
	}

	public List<Fiador> getFiadores() {
		return this.getInquilino().getFiadores();
	}
}
