package br.com.murilo.aluguel.model.builder;

import br.com.murilo.aluguel.model.Endereco;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EnderecoBuilder {

	private Long id;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private Integer numero;
	
	public EnderecoBuilder comID(Long id) {
		this.id = id;
		return this;
	}
	
	public EnderecoBuilder comCEP(String cep) {
		this.cep = cep;
		return this;
	}
	
	public EnderecoBuilder qualLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}
	
	public EnderecoBuilder qualComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}
	
	public EnderecoBuilder qualBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}
	
	public EnderecoBuilder qualCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}
	
	public EnderecoBuilder qualEstado(String estado) {
		this.estado = estado;
		return this;
	}
	
	public EnderecoBuilder qualNumero(Integer numero) {
		this.numero = numero;
		return this;
	}
	
	public Endereco build() {
		return new Endereco(id, cep, logradouro, complemento, bairro, cidade, estado, numero);
	}
}
