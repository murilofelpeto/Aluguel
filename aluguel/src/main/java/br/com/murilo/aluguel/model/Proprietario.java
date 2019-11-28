package br.com.murilo.aluguel.model;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.murilo.aluguel.types.EstadoCivil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "proprietario")
@AllArgsConstructor
@NoArgsConstructor
public class Proprietario implements Serializable {

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

	@Column(name = "estado_civil", nullable = false)
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;

	@Column(name = "nacionalidade", nullable = false, length = 80)
	private String nacionalidade;
	
	@OneToMany(mappedBy = "proprietario", cascade = {PERSIST, MERGE, DETACH, REFRESH}, fetch = FetchType.LAZY)
	private List<Casa> casas;
	
	//TODO métodos para update de proprietario
	public void addCasa(Casa casa) {
		this.casas.add(casa);
		casa.setProprietario(this);
	}
	
	public void removeCasa(Casa casa) {
		this.casas.remove(casa);
		casa.setProprietario(null);
	}
}
