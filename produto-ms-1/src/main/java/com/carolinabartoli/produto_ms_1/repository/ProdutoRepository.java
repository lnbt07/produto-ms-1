package com.carolinabartoli.produto_ms_1.repository;

import com.carolinabartoli.produto_ms_1.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

// Princípio de Inversão de Dependência (DIP):
// Esta interface agora define as operações de dados para os produtos
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("SELECT p FROM Produto p WHERE (:nome IS NULL OR p.nome LIKE %:nome%) AND (:categoria IS NULL OR p.categoria LIKE %:categoria%) AND (:preco IS NULL OR p.preco <= :preco)")
    List<Produto> buscarProdutosFiltrados(@Param("nome") String nome, @Param("categoria") String categoria, @Param("preco") BigDecimal preco);
}