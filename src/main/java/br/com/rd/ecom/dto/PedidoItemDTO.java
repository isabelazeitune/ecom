package br.com.rd.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemDTO {

    private Integer codPedidoItem;
    private BigDecimal vlProduto;
    private BigDecimal vlFrete;
    private Integer quantidade;
    private Integer codProduto;
    private Integer codPedido;

}
