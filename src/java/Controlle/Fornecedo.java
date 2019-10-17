/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlle;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rogerio
 */
@Entity
@Table(name = "fornecedo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedo.findAll", query = "SELECT f FROM Fornecedo f"),
    @NamedQuery(name = "Fornecedo.findByCodigoFornecedo", query = "SELECT f FROM Fornecedo f WHERE f.codigoFornecedo = :codigoFornecedo"),
    @NamedQuery(name = "Fornecedo.findByNome", query = "SELECT f FROM Fornecedo f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fornecedo.findByDescricao", query = "SELECT f FROM Fornecedo f WHERE f.descricao = :descricao")})
public class Fornecedo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoFornecedo")
    private Integer codigoFornecedo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "fornecedocodigoFornecedo")
    private Collection<Controleestoque> controleestoqueCollection;

    public Fornecedo() {
    }

    public Fornecedo(Integer codigoFornecedo) {
        this.codigoFornecedo = codigoFornecedo;
    }

    public Fornecedo(Integer codigoFornecedo, String nome, String descricao) {
        this.codigoFornecedo = codigoFornecedo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getCodigoFornecedo() {
        return codigoFornecedo;
    }

    public void setCodigoFornecedo(Integer codigoFornecedo) {
        this.codigoFornecedo = codigoFornecedo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Controleestoque> getControleestoqueCollection() {
        return controleestoqueCollection;
    }

    public void setControleestoqueCollection(Collection<Controleestoque> controleestoqueCollection) {
        this.controleestoqueCollection = controleestoqueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFornecedo != null ? codigoFornecedo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedo)) {
            return false;
        }
        Fornecedo other = (Fornecedo) object;
        if ((this.codigoFornecedo == null && other.codigoFornecedo != null) || (this.codigoFornecedo != null && !this.codigoFornecedo.equals(other.codigoFornecedo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlle.Fornecedo[ codigoFornecedo=" + codigoFornecedo + " ]";
    }
    
}
