package pontocristao.modelo;

import javax.persistence.*;

/**
 *
 * @author marco
 */
@Entity
public class Produto extends ProdutoBase {

    @ManyToOne(optional = false)
    private TipoProduto tipoProduto;

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
