package br.com.avaliacao.apiattornatus.repository;

import br.com.avaliacao.apiattornatus.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaDAO extends JpaRepository<Pessoa, Long> {
}
