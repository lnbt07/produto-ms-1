package com.carolinabartoli.produto_ms_1.controller;

import com.carolinabartoli.produto_ms_1.model.Produto;
import com.carolinabartoli.produto_ms_1.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        Produto produtoExistente = service.buscarPorId(id);
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());
        return service.salvar(produtoExistente);
    }
}
