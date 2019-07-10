package br.com.murilo.aluguel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.murilo.aluguel.data.model.Casa;

@Repository
public interface CasaRepository extends JpaRepository<Casa, Long> {

	List<Casa> findByProprietarioId(Long id);
	Optional<Casa> findByEnderecoCep(String cep);
	Optional<Casa> findByInquilinoId(Long id);
}
