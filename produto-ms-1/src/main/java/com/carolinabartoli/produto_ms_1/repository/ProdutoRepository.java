package com.carolinabartoli.produto_ms_1.repository;

import com.carolinabartoli.produto_ms_1.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Princípio de Inversão de Dependência (DIP):
// Esta interface agora define as operações de dados para os produtos
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
