package br.com.avaliacao.apiattornatus.service;

import br.com.avaliacao.apiattornatus.model.Endereco;
import br.com.avaliacao.apiattornatus.model.Pessoa;

import java.util.List;

public interface PessoaService {

    void salvaPessoa(Pessoa pessoa);

    Pessoa buscaPessoaPorId(Long id);

    List<Pessoa> buscaTodasPessoas();

    void alteraEnderecoPrincipal(Long idPessoa, Long idEndereco);

    List<Endereco> listaTodosEnderecos(Long id);

    Endereco buscaEnderecoPrincipal(Long id);

}
