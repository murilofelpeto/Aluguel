package br.com.murilo.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.murilo.aluguel.model.Fiador;

@Repository
public interface FiadorRepository extends JpaRepository<Fiador, Long> {

}
