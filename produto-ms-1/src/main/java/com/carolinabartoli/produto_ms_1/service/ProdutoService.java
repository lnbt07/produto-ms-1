package com.carolinabartoli.produto_ms_1.service;

import com.carolinabartoli.produto_ms_1.model.Produto;
import com.carolinabartoli.produto_ms_1.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

// Princípio de Abstração (AP)
@Service
public class ProdutoService {

    // Injeção de dependência (DIP)
    private final ProdutoRepository repository;
    private final RabbitMQService rabbitMQService;

    @Autowired
    public ProdutoService(ProdutoRepository repository, RabbitMQService rabbitMQService) {
        this.repository = repository;
        this.rabbitMQService = rabbitMQService;
    }

    // Delegação para o repositório
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    // Delegação para o repositório
    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    // Realiza lógica de negócio e envia mensagem para RabbitMQ
    public Produto salvar(Produto produto) {
        Produto produtoSalvo = repository.save(produto);
        rabbitMQService.enviarMensagem(produtoSalvo);
        return produtoSalvo;
    }

    // Realiza lógica de negócio e delega exclusão para o repositório
    public void excluir(Long id) {
        Produto produto = buscarPorId(id);
        if (produto != null) {
            repository.deleteById(id);
        }
    }

    // Realiza lógica de negócio e delega atualização para o repositório
    public Produto atualizar(Long id, Produto produto) {
        Produto produtoExistente = buscarPorId(id);
        if (produtoExistente != null) {
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setPreco(produto.getPreco());
            return repository.save(produtoExistente);
        } else {
            throw new NoSuchElementException();
        }
    }
}

