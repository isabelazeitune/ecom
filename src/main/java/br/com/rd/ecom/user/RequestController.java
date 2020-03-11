package br.com.rd.ecom.user;

import br.com.rd.ecom.repository.RequestRepository;
import br.com.rd.ecom.user.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/request")
    public Pedido save (@RequestBody Pedido pedido) { return requestRepository.save(pedido); }
}

