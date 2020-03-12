package br.com.rd.ecom.dto;

import br.com.rd.ecom.model.entity.PedidoItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Long codPedido;
    private Date dtPedido;
    private Date dtAtualizacao;
    private Integer cliente;
    private BigDecimal vlPedido;
    private BigDecimal vlFrete;
    private String dsFormaPagamento;
    private List<PedidoItemDTO> pedidoItem;
}