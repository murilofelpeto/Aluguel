package br.com.murilo.aluguel.dto.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.murilo.aluguel.model.Fiador;
import br.com.murilo.aluguel.model.Inquilino;
import lombok.Getter;

@Getter
public class InquilinoResponse {

	private Long id;
	private String nome;
	private Long rg;
	private Long cpf;
	private String estadoCivil;
	private String nacionalidade;
	private String profissao;
	private BigDecimal renda;
	private List<FiadorResponse> fiadores;
	
	public InquilinoResponse(Inquilino inquilino) {
		this.id = inquilino.getId();
		this.nome = inquilino.getNome();
		this.rg = inquilino.getRg();
		this.cpf = inquilino.getCpf();
		this.estadoCivil = inquilino.getEstadoCivil();
		this.nacionalidade = inquilino.getNacionalidade();
		this.profissao = inquilino.getProfissao();
		this.renda = inquilino.getRenda();
		this.fiadores = getFiadoresResponse(inquilino.getFiadores());
		}

		private List<FiadorResponse> getFiadoresResponse(List<Fiador> fiadores) {
			return fiadores.stream()
					.map(fiador -> new FiadorResponse(fiador))
					.collect(Collectors.toList());
		}
}
