package com.carolinabartoli.produto_ms_1.service;

import com.carolinabartoli.produto_ms_1.model.Produto;
import com.carolinabartoli.produto_ms_1.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ProdutoServiceTest {
    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testBuscarProdutoPorId() {
        // cenário
        Long id = 1L;
        Produto produto = new Produto();
        produto.setPreco(10.00);
        produto.setNome("Teste");
        produto.setId(id);

        when(produtoRepository.findById(id)).thenReturn(Optional.of(produto));

        // ação
        Produto resultado = produtoService.buscarPorId(id);

        // verificação
        assertEquals(produto, resultado);
    }

    @Test
    void testCriarProduto() {
        // cenário
        Produto produto = new Produto();
        produto.setPreco(9.99);
        produto.setNome("Teste");

        when(produtoRepository.save(produto)).thenReturn(produto);

        // ação
        Produto resultado = produtoService.salvar(produto);

        // verificação
        assertEquals(produto, resultado);
        assertEquals(produto.getNome(), resultado.getNome());
        assertEquals(produto.getPreco(), resultado.getPreco());
    }

    @Test
    void testExcluirProdutoExistente() {
        // Cenário
        Long id = 1L;
        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome("Produto 1");
        produto.setPreco(10.99);
        when(produtoRepository.findById(id)).thenReturn(Optional.of(produto));

        // Ação
        produtoService.excluir(id);

        // Verificação
        verify(produtoRepository, times(1)).deleteById(id);
    }

    @Test
    void testExcluirProdutoInexistente() {
        // Cenário
        Long id = 1L;
        when(produtoRepository.findById(id)).thenReturn(Optional.empty());

        // Ação e Verificação
        assertThrows(NoSuchElementException.class, () -> produtoService.excluir(id));
    }

    @Test
    void testAtualizarProdutoExistente() {
        // Cenário
        Long id = 1L;
        Produto produtoExistente = new Produto();
        produtoExistente.setId(id);
        produtoExistente.setNome("Produto 1");
        produtoExistente.setPreco(10.99);

        Produto produtoNovo = new Produto();
        produtoNovo.setId(id);
        produtoNovo.setNome("Produto 2");
        produtoNovo.setPreco(9.99);
        when(produtoRepository.findById(id)).thenReturn(Optional.of(produtoExistente));

        produtoService.atualizar(produtoExistente, produtoNovo);

        // Verificação
        verify(produtoRepository, times(1)).save(produtoExistente);
    }

    @Test
    void testAtualizarProdutoInexistente() {
        // Cenário
        Long id = 1L;
        Produto produtoNovo = new Produto();
        produtoNovo.setId(2L);
        produtoNovo.setNome("Produto 2");
        produtoNovo.setPreco(9.99);

        Produto produtoAntigo = new Produto();
        produtoAntigo.setId(id);

        // Ação e Verificação
        assertThrows(NoSuchElementException.class, () -> produtoService.atualizar(produtoAntigo, produtoNovo));
    }

    @Test
    void testListarTodos() {
        Produto produto1 = new Produto();
        produto1.setId(1L);
        produto1.setNome("Produto 1");
        produto1.setPreco(10.99);

        Produto produto2 = new Produto();
        produto2.setId(2L);
        produto2.setNome("Produto 2");
        produto2.setPreco(9.99);
        List<Produto> produtos = Arrays.asList(
                produto1,produto2
        );
        when(produtoRepository.findAll()).thenReturn(produtos);

        // Ação
        List<Produto> resultado = produtoService.listarTodos();

        // Verificação
        assertEquals(produtos, resultado);
        verify(produtoRepository, times(1)).findAll();
    }

    @Test
    void testExcluirProdutoThrowException(){
        assertThrows(NoSuchElementException.class, () -> produtoService.excluir(1L));
    }
}
