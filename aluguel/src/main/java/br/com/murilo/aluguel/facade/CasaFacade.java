package br.com.murilo.aluguel.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.murilo.aluguel.dto.request.CasaRequest;
import br.com.murilo.aluguel.dto.request.EnderecoRequest;
import br.com.murilo.aluguel.dto.request.InquilinoRequest;
import br.com.murilo.aluguel.dto.request.ProprietarioRequest;
import br.com.murilo.aluguel.dto.response.CasaResponse;
import br.com.murilo.aluguel.model.Casa;
import br.com.murilo.aluguel.model.Endereco;
import br.com.murilo.aluguel.model.Inquilino;
import br.com.murilo.aluguel.model.Proprietario;
import br.com.murilo.aluguel.model.builder.CasaBuilder;
import br.com.murilo.aluguel.service.CasaService;

@Component
public class CasaFacade {

	@Autowired
	private CasaService casaService;
	
	public List<CasaResponse> findCasaByProprietario(String name){
		return casaService.findCasaByProprietarioName(name)
				.stream()
				.map(casa -> new CasaResponse(casa))
				.collect(Collectors.toList());
	}
	
	public List<CasaResponse> findCasaByCep(String cep){
		return casaService.findByCEP(cep)
				.stream()
				.map(casa -> new CasaResponse(casa))
				.collect(Collectors.toList());
	}
	
	public CasaResponse salvarCasa(CasaRequest casaRequest) {
		Casa casa = buildCasa(casaRequest);
		
		return null;
	}

	private Casa buildCasa(CasaRequest casa) {
		return new CasaBuilder()
				.comID(casa.getId())
				.qualEndereco(buildEndereco(casa.getEndereco()))
				.qualInquilino(buildInquilino(casa.getInquilino()))
				.qualProprietario(buildProprietario(casa.getProprietario()))
				.qualTipoCasa(casa.getTipoCasa())
				.qualValorAluguel(casa.getValorAluguel())
				.qualValorIPTU(casa.getValorIPTU())
				.quandoVenceAluguel(casa.getDataVencimento())
				.build();
	}

	private Proprietario buildProprietario(ProprietarioRequest proprietario) {
		// TODO Auto-generated method stub
		return null;
	}

	private Inquilino buildInquilino(InquilinoRequest inquilino) {
		// TODO Auto-generated method stub
		return null;
	}

	private Endereco buildEndereco(EnderecoRequest endereco) {
		// TODO Auto-generated method stub
		return null;
	}
}
