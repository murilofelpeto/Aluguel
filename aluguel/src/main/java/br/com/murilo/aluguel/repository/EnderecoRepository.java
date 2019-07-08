package br.com.murilo.aluguel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.murilo.aluguel.data.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Optional<Endereco> findByCepAndLogradouroAndNumero(Integer cep, String logradouro, Integer numero);
}
