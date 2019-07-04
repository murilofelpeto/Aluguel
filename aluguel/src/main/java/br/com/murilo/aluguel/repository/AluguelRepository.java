package br.com.murilo.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.murilo.aluguel.data.model.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

}
