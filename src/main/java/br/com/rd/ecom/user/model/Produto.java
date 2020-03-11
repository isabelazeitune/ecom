package br.com.rd.ecom.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codProduto;

    @Column(name = "ds_produto", nullable = false)
    private String descCategoria;

    @ManyToOne
    @JoinColumn(name="cd_categoria")
    private Categoria categoria;
    // relacionamento de 1 pra 1 na categoria

    @Column(name="vl_produto")
    private BigDecimal vlProduto;

}
