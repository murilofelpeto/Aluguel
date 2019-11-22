package br.com.murilo.aluguel.facade;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.murilo.aluguel.dto.request.CasaRequest;
import br.com.murilo.aluguel.dto.request.EnderecoRequest;
import br.com.murilo.aluguel.dto.request.FiadorRequest;
import br.com.murilo.aluguel.dto.request.InquilinoRequest;
import br.com.murilo.aluguel.dto.request.ProprietarioRequest;
import br.com.murilo.aluguel.dto.response.CasaResponse;
import br.com.murilo.aluguel.model.Casa;
import br.com.murilo.aluguel.model.Endereco;
import br.com.murilo.aluguel.model.Fiador;
import br.com.murilo.aluguel.model.Inquilino;
import br.com.murilo.aluguel.model.Proprietario;
import br.com.murilo.aluguel.model.builder.CasaBuilder;
import br.com.murilo.aluguel.model.builder.EnderecoBuilder;
import br.com.murilo.aluguel.model.builder.FiadorBuilder;
import br.com.murilo.aluguel.model.builder.InquilinoBuilder;
import br.com.murilo.aluguel.model.builder.ProprietarioBuilder;
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
		return new CasaResponse(casaService.salvarCasa(casa));
		
	}
	
	public CasaResponse atualizarCasa(Long casaID, CasaRequest casaRequest) {
		Casa casa = buildCasa(casaRequest);
		return new CasaResponse(casaService.atualizarCasa(casaID, casa));
	}
	
	public void deleteCasa(Long id) {
		casaService.deleteCasa(id);
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
		return new ProprietarioBuilder()
				.comID(proprietario.getId())
				.comCPF(proprietario.getCpf())
				.comNome(proprietario.getNome())
				.comRG(proprietario.getRg())
				.qualEstadoCivil(proprietario.getEstadoCivil())
				.qualNacionalidade(proprietario.getNacionalidade())
				.build();
	}

	private Inquilino buildInquilino(InquilinoRequest inquilino) {
		return new InquilinoBuilder()
				.comID(inquilino.getId())
				.quaisOsFiadores(buildFiador(inquilino.getFiadores()))
				.qualCPF(inquilino.getCpf())
				.qualEstadoCivil(inquilino.getEstadoCivil())
				.qualNacionalidade(inquilino.getNacionalidade())
				.qualNome(inquilino.getNome())
				.qualProfissao(inquilino.getProfissao())
				.qualRenda(inquilino.getRenda())
				.qualRG(inquilino.getRg())
				.build();
	}

	private List<Fiador> buildFiador(List<FiadorRequest> fiadoresRequest) {
		return fiadoresRequest.stream().map(f -> {
			return new FiadorBuilder()
			.comID(f.getId())
			.qualDocumento(f.getDocumento())
			.qualNome(f.getNome())
			.qualRenda(f.getRenda())
			.qualRG(f.getRg())
			.qualTipoDoDocumento(f.getTipoDocumento())
			.build();
			})
				.collect(Collectors.toList()); 
	}

	private Endereco buildEndereco(EnderecoRequest endereco) {
		return new EnderecoBuilder()
				.comCEP(endereco.getCep())
				.comID(endereco.getId())
				.qualBairro(endereco.getBairro())
				.qualCidade(endereco.getCidade())
				.qualComplemento(endereco.getComplemento())
				.qualEstado(endereco.getEstado())
				.qualLogradouro(endereco.getLogradouro())
				.qualNumero(endereco.getNumero())
				.build();
	}
}
