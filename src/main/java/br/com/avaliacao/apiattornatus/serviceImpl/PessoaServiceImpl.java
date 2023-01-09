package br.com.avaliacao.apiattornatus.serviceImpl;

import br.com.avaliacao.apiattornatus.model.Endereco;
import br.com.avaliacao.apiattornatus.model.Pessoa;
import br.com.avaliacao.apiattornatus.repository.EnderecoDAO;
import br.com.avaliacao.apiattornatus.repository.PessoaDAO;
import br.com.avaliacao.apiattornatus.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaDAO dao;

    private final EnderecoDAO enderecoDAO;

    @Override
    public void salvaPessoa(Pessoa pessoa) {

        if (!Objects.isNull(pessoa.getEnderecos()) && !pessoa.getEnderecos().isEmpty()) {

            pessoa.getEnderecos().stream().forEach(endereco -> endereco.setPessoa(pessoa));

        }

        dao.save(pessoa);

    }

    @Override
    public Pessoa buscaPessoaPorId(Long id) {

        return dao.findById(id).orElse(null);

    }

    @Override
    public List<Pessoa> buscaTodasPessoas() {

        return dao.findAll();

    }

    @Override
    public void alteraEnderecoPrincipal(Long idPessoa, Long idEndereco) {

        Pessoa pessoa = this.buscaPessoaPorId(idPessoa);

        if (!Objects.isNull(pessoa) && !Objects.isNull(pessoa.getEnderecos()) && !pessoa.getEnderecos().isEmpty()) {

            pessoa.getEnderecos().stream().forEach(endereco -> {

                endereco.setPrincipal(endereco.getId().equals(idEndereco));

            });

            dao.save(pessoa);

        }

    }

    @Override
    public List<Endereco> listaTodosEnderecos(Long id) {

        Pessoa pessoa = this.buscaPessoaPorId(id);

        if (!Objects.isNull(pessoa) && !Objects.isNull(pessoa.getEnderecos()) && !pessoa.getEnderecos().isEmpty()) {

            return enderecoDAO.findAllById(pessoa.getEnderecos().stream().map(Endereco::getId).collect(Collectors.toList()));

        } else return null;

    }

    @Override
    public Endereco buscaEnderecoPrincipal(Long id) {

        Pessoa pessoa = this.buscaPessoaPorId(id);

        if (!Objects.isNull(pessoa) && !Objects.isNull(pessoa.getEnderecos()) && !pessoa.getEnderecos().isEmpty()) {

            return pessoa.getEnderecos().stream().filter(Endereco::getPrincipal).findFirst().orElse(null);

        } else return null;

    }

}
