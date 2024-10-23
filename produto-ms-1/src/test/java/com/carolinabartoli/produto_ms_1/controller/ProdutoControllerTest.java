package com.carolinabartoli.produto_ms_1.controller;

import com.carolinabartoli.produto_ms_1.model.Produto;
import com.carolinabartoli.produto_ms_1.repository.ProdutoRepository;
import com.carolinabartoli.produto_ms_1.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProdutoControllerTest {

    @Mock
    private ProdutoService service;

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoController controller;

    private Produto produto;

    @BeforeEach
    void init() {
        produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto 1");
        produto.setPreco(10.99);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListarTodos() {
        // Cenário
        List<Produto> produtos = Collections.singletonList(produto);
        when(service.listarTodos()).thenReturn(produtos);

        // Ação
        List<Produto> resposta = controller.listarTodos();

        // Verificação
        assertEquals(produtos, resposta);
        verify(service, times(1)).listarTodos();
    }

    @Test
    void testBuscarPorIdExistente() {
        // Cenário
        when(service.buscarPorId(1L)).thenReturn(produto);

        // Ação
        Produto resposta = controller.buscarPorId(1L);

        // Verificação
        assertEquals(produto, resposta);
        verify(service, times(1)).buscarPorId(1L);
    }

    @Test
    void testBuscarPorIdInexistente() {
        // Cenário
        when(service.buscarPorId(1L)).thenReturn(null);

        // Ação
        Produto resposta = controller.buscarPorId(1L);

        // Verificação
        verify(service, times(1)).buscarPorId(1L);
        assertNull(resposta);
    }

    @Test
    void testSalvar() {
        // Cenário
        when(service.salvar(produto)).thenReturn(produto);

        // Ação
        Produto resposta = controller.salvar(produto);

        // Verificação
        assertEquals(produto, resposta);
        verify(service, times(1)).salvar(produto);
    }

    @Test
    void testExcluir() {
        // Ação
        controller.excluir(1L);

        // Verificação
        verify(service, times(1)).excluir(1L);
    }

    @Test
    void testAtualizarExistente() {
        // Cenário
        Produto produtoAtualizado = new Produto();
        produtoAtualizado.setId(1L);
        produtoAtualizado.setNome("Produto atualizado");
        produtoAtualizado.setPreco(9.99);
        when(service.buscarPorId(1L)).thenReturn(produto);
        when(service.atualizar(produto.getId(), produtoAtualizado)).thenReturn(produtoAtualizado);
        when(repository.save(produto)).thenReturn(produtoAtualizado);
        // Ação
        Produto resposta = controller.atualizar(1L, produtoAtualizado);

        // Verificação
        assertEquals(produtoAtualizado, resposta);
    }

    @Test
    void testAtualizarInexistente() {
        // Cenário
        Produto produtoAtualizado = new Produto();
        produtoAtualizado.setNome("Produto atualizado");
        produtoAtualizado.setPreco(9.99);
        when(service.buscarPorId(1L)).thenReturn(null);

        // Ação
        Produto resposta = controller.atualizar(1L, produtoAtualizado);

        // Verificação
        assertNull(resposta);

    }
}
