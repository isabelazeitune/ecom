package br.com.rd.ecom.user;

import br.com.rd.ecom.user.model.Produto;
import br.com.rd.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-product")
    public Produto save (@RequestBody Produto produto) { return productRepository.save(produto); }

    @GetMapping("/find-products/list")
    public List<Produto> find() { return productRepository.findAll(); }

//    @GetMapping("/product/list")
//    public Produto find() { return productRepository.findByCodProduto(codProduto); }

}
