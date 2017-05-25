package pontocristao.modelo;

import java.util.*;
import javax.persistence.*;

/**
 *
 * @author Marcondes
 */
@Entity
public class ContaPagar extends ModeloBase {

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Date dataVencimento;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne()
    private TipoContaPagar tipoContaPagar;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoContaPagar getTipoContaPagar() {
        return tipoContaPagar;
    }

    public void setTipoContaPagar(TipoContaPagar tipoContaPagar) {
        this.tipoContaPagar = tipoContaPagar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
