package br.com.rd.ecom.user;

import br.com.rd.ecom.user.model.Categoria;
import br.com.rd.ecom.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
}
