package br.com.rd.ecom.repository;

import br.com.rd.ecom.user.model.Categoria;
import br.com.rd.ecom.user.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCodProduto(Integer codProduto);
    List<Produto> findByDescCategoria(String descCategoria);
    List<Produto> findByCategoria(Categoria categoria);
    List<Produto> findByVlProduto(BigDecimal vlProduto);
}