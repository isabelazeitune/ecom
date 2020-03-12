package br.com.rd.ecom.controller;

import br.com.rd.ecom.dto.PedidoDTO;
import br.com.rd.ecom.repository.RequestRepository;
import br.com.rd.ecom.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {

    @Autowired
    //private RequestRepository requestRepository;
    RequestService requestService;

    //@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/request")
    public ResponseEntity save (@RequestBody PedidoDTO pedido) {
        return ResponseEntity.ok().body(requestService.save(pedido));
    }
}

