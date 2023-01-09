package br.com.avaliacao.apiattornatus.repository;

import br.com.avaliacao.apiattornatus.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoDAO extends JpaRepository<Endereco, Long> {
}
