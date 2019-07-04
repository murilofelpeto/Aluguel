package br.com.murilo.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.murilo.aluguel.data.model.Inquilino;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {

}
