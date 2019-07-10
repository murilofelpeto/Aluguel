package br.com.murilo.aluguel.data.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "tipoCasa", "valorAluguel", "valorIPTU", "dataVencimento", "endereco", "inquilino",
		"alugueis" })
public class CasaVO extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@JsonProperty("id")
	private Long key;
	private String tipoCasa;
	private BigDecimal valorAluguel;
	private BigDecimal valorIPTU;
	private Date dataVencimento;
	private EnderecoVO endereco;
	@JsonIgnore
	private ProprietarioVO proprietario;
	private InquilinoVO inquilino;

	public CasaVO() {
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getTipoCasa() {
		return tipoCasa;
	}

	public void setTipoCasa(String tipoCasa) {
		this.tipoCasa = tipoCasa;
	}

	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public BigDecimal getValorIPTU() {
		return valorIPTU;
	}

	public void setValorIPTU(BigDecimal valorIPTU) {
		this.valorIPTU = valorIPTU;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public EnderecoVO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoVO endereco) {
		this.endereco = endereco;
	}

	public ProprietarioVO getProprietario() {
		return proprietario;
	}

	public void setProprietario(ProprietarioVO proprietario) {
		this.proprietario = proprietario;
	}

	public InquilinoVO getInquilino() {
		return inquilino;
	}

	public void setInquilino(InquilinoVO inquilino) {
		this.inquilino = inquilino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((inquilino == null) ? 0 : inquilino.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((proprietario == null) ? 0 : proprietario.hashCode());
		result = prime * result + ((tipoCasa == null) ? 0 : tipoCasa.hashCode());
		result = prime * result + ((valorAluguel == null) ? 0 : valorAluguel.hashCode());
		result = prime * result + ((valorIPTU == null) ? 0 : valorIPTU.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CasaVO other = (CasaVO) obj;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (inquilino == null) {
			if (other.inquilino != null)
				return false;
		} else if (!inquilino.equals(other.inquilino))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (proprietario == null) {
			if (other.proprietario != null)
				return false;
		} else if (!proprietario.equals(other.proprietario))
			return false;
		if (tipoCasa == null) {
			if (other.tipoCasa != null)
				return false;
		} else if (!tipoCasa.equals(other.tipoCasa))
			return false;
		if (valorAluguel == null) {
			if (other.valorAluguel != null)
				return false;
		} else if (!valorAluguel.equals(other.valorAluguel))
			return false;
		if (valorIPTU == null) {
			if (other.valorIPTU != null)
				return false;
		} else if (!valorIPTU.equals(other.valorIPTU))
			return false;
		return true;
	}
}
