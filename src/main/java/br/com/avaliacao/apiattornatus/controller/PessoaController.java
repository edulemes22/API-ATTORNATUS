package br.com.avaliacao.apiattornatus.controller;

import br.com.avaliacao.apiattornatus.model.Endereco;
import br.com.avaliacao.apiattornatus.model.Pessoa;
import br.com.avaliacao.apiattornatus.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/pessoa")
public class PessoaController {

    /**
     * URL = http://localhost:8080/api/pessoa
     */

    private final PessoaService service;

    @PostMapping()
    void salvarPessoa(@RequestBody Pessoa pessoa) {

        service.salvaPessoa(pessoa);

    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Pessoa> encontrarPorId(@PathVariable Long id) {

        return ResponseEntity.ok().body(service.buscaPessoaPorId(id));

    }

    @GetMapping
    ResponseEntity<List<Pessoa>> encontrarTodos() {

        return ResponseEntity.ok().body(service.buscaTodasPessoas());

    }

    /**
     * @param idPessoa ID da pessoa que será alterada o endereço principal.
     * @param idEndereco ID do endereço que será o ATUAL endereço principal.
     */
    @PostMapping(value = "/endereco/{idPessoa}/{idEndereco}")
    void alteraEnderecoPrincipal(@PathVariable Long idPessoa, @PathVariable Long idEndereco) {

        service.alteraEnderecoPrincipal(idPessoa, idEndereco);

    }

    /**
     * @param id ID da pessoa que será listada os endereços.
     */
    @GetMapping(value = "/endereco/{id}")
    ResponseEntity<List<Endereco>> encontrarTodosEnderecos(@PathVariable Long id) {

        return ResponseEntity.ok().body(service.listaTodosEnderecos(id));

    }

    /**
     * @param id ID da pessoa que será procurado o endereço principal.
     */
    @GetMapping(value = "/endereco/principal/{id}")
    ResponseEntity<Endereco> encontrarEnderecoPrincipal(@PathVariable Long id) {

        return ResponseEntity.ok().body(service.buscaEnderecoPrincipal(id));

    }

}
