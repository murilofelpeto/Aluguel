package br.com.murilo.aluguel.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.murilo.aluguel.model.Casa;
import br.com.murilo.aluguel.utils.DateConverter;
import lombok.Getter;

@Getter
public class CasaProprietarioResponse {

	private Long id;
	private String tipoCasa;
	private BigDecimal valorAluguel;
	private BigDecimal valorIPTU;
	private LocalDate dataVencimento;
	private String nomeInquilino;
	private Long cpfInquilino;
	private EnderecoResponse endereco;
	
	public CasaProprietarioResponse(Casa casa) {
		this.id = casa.getId();
		this.tipoCasa = casa.getTipoCasa();
		this.valorAluguel = casa.getValorAluguel();
		this.valorIPTU = casa.getValorIPTU();
		this.dataVencimento = DateConverter.convert(casa.getDataVencimento());
		this.endereco = new EnderecoResponse(casa.getEndereco());
		this.nomeInquilino = casa.getNomeInquilino();
		this.cpfInquilino = casa.getCpfInquilino();
	}
}
