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
@Table(name = "instalacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instalacao.findAll", query = "SELECT i FROM Instalacao i"),
    @NamedQuery(name = "Instalacao.findByCodigoInstalacao", query = "SELECT i FROM Instalacao i WHERE i.codigoInstalacao = :codigoInstalacao"),
    @NamedQuery(name = "Instalacao.findByDataInstalacao", query = "SELECT i FROM Instalacao i WHERE i.dataInstalacao = :dataInstalacao"),
    @NamedQuery(name = "Instalacao.findByDescricao", query = "SELECT i FROM Instalacao i WHERE i.descricao = :descricao")})
public class Instalacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoInstalacao")
    private Integer codigoInstalacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_Instalacao")
    @Temporal(TemporalType.DATE)
    private Date dataInstalacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "Cliente_codigoCliente", referencedColumnName = "codigoCliente")
    @ManyToOne
    private Cliente clientecodigoCliente;

    public Instalacao() {
    }

    public Instalacao(Integer codigoInstalacao) {
        this.codigoInstalacao = codigoInstalacao;
    }

    public Instalacao(Integer codigoInstalacao, Date dataInstalacao, String descricao) {
        this.codigoInstalacao = codigoInstalacao;
        this.dataInstalacao = dataInstalacao;
        this.descricao = descricao;
    }

    public Integer getCodigoInstalacao() {
        return codigoInstalacao;
    }

    public void setCodigoInstalacao(Integer codigoInstalacao) {
        this.codigoInstalacao = codigoInstalacao;
    }

    public Date getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(Date dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getClientecodigoCliente() {
        return clientecodigoCliente;
    }

    public void setClientecodigoCliente(Cliente clientecodigoCliente) {
        this.clientecodigoCliente = clientecodigoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoInstalacao != null ? codigoInstalacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instalacao)) {
            return false;
        }
        Instalacao other = (Instalacao) object;
        if ((this.codigoInstalacao == null && other.codigoInstalacao != null) || (this.codigoInstalacao != null && !this.codigoInstalacao.equals(other.codigoInstalacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlle.Instalacao[ codigoInstalacao=" + codigoInstalacao + " ]";
    }
    
}
