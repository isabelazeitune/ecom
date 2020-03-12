package br.com.rd.ecom.controller;

import br.com.rd.ecom.model.entity.Produto;
import br.com.rd.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create-product")
    public Produto save(@RequestBody Produto produto) {
        return productRepository.save(produto);
    }

    @GetMapping("/product/list")
    public List<Produto> find() {
        return productRepository.findAll();
    }

    @PutMapping("/products")
    public Produto alterar(@RequestBody Produto produto) {
        Produto produtoEntity = productRepository.getOne(produto.getCodProduto());
        produtoEntity.setDescProduto(produto.getDescProduto());
        produtoEntity.setVlProduto(produto.getVlProduto());
        produtoEntity.setCategoria(produto.getCategoria());

        return productRepository.save(produtoEntity);
    }

//    @GetMapping("/product/{idProduto}")
//    public Produto findById(@PathVariable("idProduto") Long codProduto) {
//        return productRepository.findById(codProduto).get();
//    }

//    @GetMapping("/product/{descProduto}")
//    public List<Produto> findByDescProduto(@PathVariable("descProduto") String descProduto) {
//        return productRepository.findByDescProduto(descProduto);
//    }

//    @GetMapping("/product/{id}/{descProduto}")
//    public List<Produto> findByDescProduto(@PathVariable ("descProduto") String descProduto,
//                                           @PathVariable("codProduto") Long codProduto) {
//        return productRepository.findByIdAndDescProduto(codProduto, descProduto);
//    }

    @GetMapping("/produto")
    public ResponseEntity<List<Produto>> findById(@PathParam("codProduto") Long codProduto,
                                                  @PathParam("descProduto") String descProduto) {

        List<Produto> produto = new ArrayList<>();

        if (codProduto != null && descProduto != null)
            produto = productRepository.findByCodProdutoAndDescProduto(codProduto, descProduto);
        else if (codProduto != null)
            produto.add(productRepository.findById(codProduto).get());
        else if (descProduto != null)
            produto = productRepository.findByDescProduto(descProduto);

        if (produto != null && produto.size() > 0)
            return ResponseEntity.ok().body(produto);
        else
            return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/produto/{codProduto}")
    public void excluirProduto(@PathVariable("codProduto") Long codProduto) {
        productRepository.findById(codProduto);
    }
}