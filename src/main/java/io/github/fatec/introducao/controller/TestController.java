package io.github.fatec.introducao.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/pessoa")
public class TestController {

    private List<Pessoa> pessoas = new ArrayList<>();
    private Long contador = 1L;

    static class Pessoa {
        public Long id;
        public String nome;
        public String telefone;
        public String endereco;
    }

    // POST
    @PostMapping
    public Pessoa criar(@RequestBody Pessoa p) {
        p.id = contador++;
        pessoas.add(p);
        return p;
    }

    // PUT
    @PutMapping
    public Pessoa atualizar(@RequestBody Pessoa p) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.id.equals(p.id)) {
                pessoa.nome = p.nome;
                pessoa.telefone = p.telefone;
                pessoa.endereco = p.endereco;
                return pessoa;
            }
        }
        return null;
    }

    // DELETE
    @DeleteMapping
    public String deletar(@RequestBody Pessoa p) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.id.equals(p.id)) {
                pessoas.remove(pessoa);
                return "Usuario:" + p.id + ".";
            }
        }
        return "Usuario nao encontrado";
    }

    // GET
    @GetMapping
    public List<Pessoa> listar() {
        return pessoas;
    }
}