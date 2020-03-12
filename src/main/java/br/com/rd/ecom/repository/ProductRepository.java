package br.com.rd.ecom.repository;

import br.com.rd.ecom.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCodProdutoAndDescProduto(Long codProduto, String descProduto);

//    List<Produto> findByCodProduto(Integer codProduto);
    List<Produto> findByDescProduto(String descProduto);
//    List<Produto> findByCategoria(Categoria categoria);
//    List<Produto> findByVlProduto(BigDecimal vlProduto);
}