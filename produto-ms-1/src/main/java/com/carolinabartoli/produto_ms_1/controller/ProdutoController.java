package com.carolinabartoli.produto_ms_1.controller;

import com.carolinabartoli.produto_ms_1.model.Produto;
import com.carolinabartoli.produto_ms_1.service.ProdutoService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

// Princípio de Responsabilidade Única (SRP):
// Esta classe agora tem apenas a responsabilidade de lidar com requisições HTTP
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    // Injeção de dependência (DIP):
    // Removemos a criação direta do serviço e passamos a receber por injeção
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarTodos() {
        // Delegamos a lógica de negócio para o serviço
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        // Delegamos a lógica de negócio para o serviço
        return produtoService.buscarPorId(id);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        // Delegamos a lógica de negócio para o serviço
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        // Delegamos a lógica de negócio para o serviço
        produtoService.excluir(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        // Delegamos a lógica de negócio para o serviço
        return produtoService.atualizar(id, produto);
    }

    @GetMapping("/filtrar")
    public List<Produto> buscarProdutosFiltrados(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) BigDecimal preco) {
        return produtoService.buscarProdutosFiltrados(nome, categoria, preco);
    }
}
