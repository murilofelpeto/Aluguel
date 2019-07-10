package br.com.murilo.aluguel.data.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import br.com.murilo.aluguel.data.model.TipoDocumento;

@JsonPropertyOrder({ "id", "nome", "rg", "tipoDocumento", "documento", "renda" })
public class FiadorVO extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	@JsonProperty("id")
	private Long key;
	private String nome;
	private Long rg;
	private TipoDocumento tipoDocumento;
	private Long documento;
	private BigDecimal renda;

	public FiadorVO() {
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
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

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((renda == null) ? 0 : renda.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
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
		FiadorVO other = (FiadorVO) obj;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
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
		if (tipoDocumento != other.tipoDocumento)
			return false;
		return true;
	}
}
