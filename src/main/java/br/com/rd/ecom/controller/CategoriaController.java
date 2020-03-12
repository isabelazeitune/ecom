package br.com.rd.ecom.controller;

import br.com.rd.ecom.model.entity.Categoria;
import br.com.rd.ecom.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/categoria")
    public Categoria save(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

//    @GetMapping("/find-categoria/list")
//    public List<Categoria> find() {
//        return categoriaRepository.findAll();
//    }

    @GetMapping("categoria/{idCategoria}")
    //idCategoria deve ser igual ao idCategoria abaixo
    //se quiser outro, colocar "categoria/{idCategoria}/{outraCoisa}"
    public Categoria findById(@PathVariable("idCategoria") Long idCategoria) {
        return categoriaRepository.findById(idCategoria).get();
    }

    @GetMapping("/categoria")
    public Categoria findCategoriaById(@Param("id") Long id) {
        return categoriaRepository.findById(id).get();
    }

    @DeleteMapping("/categoria/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        categoriaRepository.deleteById(id);
    }

//    @PutMapping("/categoria")
//    public Categoria alterar(@RequestBody Categoria categoria) {
//        Categoria categoriaEntity = categoriaRepository.getOne(categoria.getCodCategoria());
//        categoriaEntity.setDescCategoria(categoria.getDescCategoria());
//        return categoriaRepository.save(categoriaEntity);
//    }

    @PutMapping("/categoria")
    public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria) {
        Categoria categoriaEntity = categoriaRepository.getOne(categoria.getCodCategoria());
        categoriaEntity.setDescCategoria(categoria.getDescCategoria());
        Categoria categoriaAtualiza = categoriaRepository.save(categoriaEntity);
        return ResponseEntity.ok().body(categoriaAtualiza);
    }

    //PATCH NÃO É COMPATÍVEL COM VERSÃO ANTIGA DE BROWSER
    //funciona para alterar só um campo, mas pode dar erro quando os outros são not null ??
    @PatchMapping("/categoria")
    public ResponseEntity<Categoria> alterarVariaveis(@RequestBody Categoria categoria) {
        Categoria categoriaEntity = categoriaRepository.getOne(categoria.getCodCategoria());
        categoriaEntity.setDescCategoria(categoria.getDescCategoria());
        Categoria categoriaAtualiza = categoriaRepository.save(categoriaEntity);
        return ResponseEntity.ok().body(categoriaAtualiza);
    }

}
