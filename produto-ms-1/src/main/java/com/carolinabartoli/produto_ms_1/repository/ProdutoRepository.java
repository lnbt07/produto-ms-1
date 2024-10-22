package com.carolinabartoli.produto_ms_1.repository;

import com.carolinabartoli.produto_ms_1.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
