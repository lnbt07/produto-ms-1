package com.carolinabartoli.produto_ms_1.service;

import com.carolinabartoli.produto_ms_1.model.Produto;
import com.carolinabartoli.produto_ms_1.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public void excluir(Long id) {
        Produto produto = this.buscarPorId(id);
        if(produto!= null){
            repository.deleteById(id);
        }
    }

    public Produto atualizar(Produto produtoExistente, Produto produto) {
        if(produto.getId().equals(produtoExistente.getId())){
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setPreco(produto.getPreco());
            return repository.save(produtoExistente);
        } else {
            throw new NoSuchElementException();
        }
    }
}
