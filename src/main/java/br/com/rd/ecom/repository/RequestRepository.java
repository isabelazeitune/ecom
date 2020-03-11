package br.com.rd.ecom.repository;

import br.com.rd.ecom.user.model.Pedido;
import br.com.rd.ecom.user.model.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Pedido, Long> {

//    List<Pedido> findByCodPedido(Integer codPedido);
//    List<Pedido> findByDtPedido(Date dtPedido);
//    List<Pedido> findByIdCliente(Integer idCliente);
//    List<Pedido> findByVlPedido(BigDecimal vlPedido);
//    List<Pedido> findByVlFrete(BigDecimal vlFrete);
//    List<Pedido> findByDsFormaPagamento(String dsFormaPagamento);
//    List<Pedido> findByPedidoItem(List<PedidoItem> pedidoItem);
}
