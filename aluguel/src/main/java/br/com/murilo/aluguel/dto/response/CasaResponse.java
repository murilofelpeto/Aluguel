package br.com.murilo.aluguel.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.murilo.aluguel.model.Casa;
import br.com.murilo.aluguel.model.Fiador;
import br.com.murilo.aluguel.utils.DateConverter;
import lombok.Getter;

@Getter
public class CasaResponse implements Serializable {

	private static final long serialVersionUID = -1096284309872358721L;

	private Long id;
	private String tipoCasa;
	private BigDecimal valorAluguel;
	private BigDecimal valorIPTU;
	private LocalDate dataVencimento;
	private String cep;
	private String endereco;
	private Integer numero;
	private String nomeProprietario;
	private String nomeInquilino;
	private Long cpfInquilino;
	private List<FiadorResponse> fiadores;
	
	public CasaResponse(Casa casa) {
		this.id = casa.getId();
		this.tipoCasa = casa.getTipoCasa();
		this.valorAluguel = casa.getValorAluguel();
		this.valorIPTU = casa.getValorIPTU();
		this.dataVencimento = DateConverter.convert(casa.getDataVencimento());
		this.cep = casa.getCep();
		this.endereco = casa.getEnderecoCompleto();
		this.numero = casa.getNumero();
		this.nomeProprietario = casa.getNomeProprietario();
		this.nomeInquilino = casa.getNomeInquilino();
		this.cpfInquilino = casa.getCpfInquilino();
		this.fiadores = getFiadoresResponse(casa.getFiadores());
	}

	private List<FiadorResponse> getFiadoresResponse(List<Fiador> fiadores) {
		return fiadores.stream()
				.map(fiador -> new FiadorResponse(fiador))
				.collect(Collectors.toList());
	}
}
