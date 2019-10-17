/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlle;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rogerio
 */
@Entity
@Table(name = "controleestoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Controleestoque.findAll", query = "SELECT c FROM Controleestoque c"),
    @NamedQuery(name = "Controleestoque.findByCodigoProduto", query = "SELECT c FROM Controleestoque c WHERE c.codigoProduto = :codigoProduto"),
    @NamedQuery(name = "Controleestoque.findByProdutos", query = "SELECT c FROM Controleestoque c WHERE c.produtos = :produtos"),
    @NamedQuery(name = "Controleestoque.findByDescricao", query = "SELECT c FROM Controleestoque c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Controleestoque.findByValor", query = "SELECT c FROM Controleestoque c WHERE c.valor = :valor"),
    @NamedQuery(name = "Controleestoque.findByData", query = "SELECT c FROM Controleestoque c WHERE c.data = :data")})
public class Controleestoque implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoProduto")
    private Integer codigoProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "produtos")
    private String produtos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "Fornecedo_codigoFornecedo", referencedColumnName = "codigoFornecedo")
    @ManyToOne
    private Fornecedo fornecedocodigoFornecedo;

    public Controleestoque() {
    }

    public Controleestoque(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Controleestoque(Integer codigoProduto, String produtos, String descricao, String valor, Date data) {
        this.codigoProduto = codigoProduto;
        this.produtos = produtos;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Fornecedo getFornecedocodigoFornecedo() {
        return fornecedocodigoFornecedo;
    }

    public void setFornecedocodigoFornecedo(Fornecedo fornecedocodigoFornecedo) {
        this.fornecedocodigoFornecedo = fornecedocodigoFornecedo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProduto != null ? codigoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controleestoque)) {
            return false;
        }
        Controleestoque other = (Controleestoque) object;
        if ((this.codigoProduto == null && other.codigoProduto != null) || (this.codigoProduto != null && !this.codigoProduto.equals(other.codigoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlle.Controleestoque[ codigoProduto=" + codigoProduto + " ]";
    }
    
}
