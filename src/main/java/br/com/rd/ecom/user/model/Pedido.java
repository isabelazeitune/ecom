package br.com.rd.ecom.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cd_pedido")
    private Integer codPedido;

    @Column(name="dt_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPedido;

    @Column(name="id_cliente")
    private Integer idCliente;

    @Column(name="vl_pedido")
    private BigDecimal vlPedido;

    @Column(name="vl_frete")
    private BigDecimal vlFrete;

    @Column(name="dr_forma_pagto")
    private String dsFormaPagamento;

    @OneToMany(mappedBy = "pedido")
    private List<PedidoItem> pedidoItem;
}
