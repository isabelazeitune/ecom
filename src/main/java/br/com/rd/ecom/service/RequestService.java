package br.com.rd.ecom.service;

import br.com.rd.ecom.dto.PedidoDTO;
import br.com.rd.ecom.dto.PedidoItemDTO;
import br.com.rd.ecom.model.entity.Pedido;
import br.com.rd.ecom.model.entity.PedidoItem;
import br.com.rd.ecom.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("RequestService")
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

//    public Pedido save(Pedido pedido) {
//        return requestRepository.save(pedido);
//    }

    public ResponseEntity save(PedidoDTO pedidoDTO) {
        // criar entidade manualmente
        // passar novo objeto para o repository
        // TODO incluir validações
        if(pedidoDTO == null || pedidoDTO.getCliente() == null)
            return ResponseEntity.badRequest().body(new Exception("idCliente não informado"));

        if(pedidoDTO.getPedidoItem() == null)
            return ResponseEntity.badRequest().body(new Exception("Pedido não contém itens"));

        Pedido pedidoEntity = new Pedido();
        pedidoEntity.setDtPedido(pedidoDTO.getDtPedido());
        pedidoEntity.setIdCliente(pedidoDTO.getCliente());
        pedidoEntity.setVlPedido(pedidoDTO.getVlPedido());
        pedidoEntity.setVlFrete(pedidoDTO.getVlFrete());
        pedidoEntity.setDsFormaPagamento(pedidoDTO.getDsFormaPagamento());
        pedidoEntity.setDtAtualizacao(new Date());

        List<PedidoItem> listaItens = new ArrayList<>();

        for(PedidoItemDTO pedIt: pedidoDTO.getPedidoItem()) {
            PedidoItem it = new PedidoItem();
            it.setVlProduto(pedIt.getVlProduto());
            it.setQuantidade(pedIt.getQuantidade());
            it.setCodProduto(pedIt.getCodProduto());
            it.setVlFrete(pedIt.getVlFrete());

            listaItens.add(it);
        }

        pedidoEntity.setPedidoItem(listaItens);

        Pedido retornoEntity = requestRepository.save(pedidoEntity);

        pedidoDTO.setCodPedido(retornoEntity.getCodPedido());
          return ResponseEntity.ok().body(pedidoDTO);
    }

}
