package br.com.rd.ecom.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_pedido_item")
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cd_pedido_item")
    private Integer codPedidoItem;

    @Column(name="vl_produto")
    private BigDecimal vlProduto;

    @Column(name="vl_frete")
    private BigDecimal vlFrete;

    @Column(name="quantidade")
    private Integer quantidade;

    @Column(name="cd_produto")
    private Integer codProduto;

//    @ManyToOne
//    @JoinColumn(name="cd_pedido")
//    private Pedido pedido;

    @Column(name = "cd_pedido")
    private Integer codPedido;
}
