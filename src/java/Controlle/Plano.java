/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlle;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rogerio
 */
@Entity
@Table(name = "plano")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plano.findAll", query = "SELECT p FROM Plano p"),
    @NamedQuery(name = "Plano.findByCodigoPlano", query = "SELECT p FROM Plano p WHERE p.codigoPlano = :codigoPlano"),
    @NamedQuery(name = "Plano.findByNome", query = "SELECT p FROM Plano p WHERE p.nome = :nome"),
    @NamedQuery(name = "Plano.findByQtMega", query = "SELECT p FROM Plano p WHERE p.qtMega = :qtMega"),
    @NamedQuery(name = "Plano.findByValor", query = "SELECT p FROM Plano p WHERE p.valor = :valor")})
public class Plano implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoPlano")
    private Integer codigoPlano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "qtMega")
    private String qtMega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private long valor;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "codigoCliente")
    @ManyToOne
    private Cliente clienteidCliente;

    public Plano() {
    }

    public Plano(Integer codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    public Plano(Integer codigoPlano, String nome, String qtMega, long valor) {
        this.codigoPlano = codigoPlano;
        this.nome = nome;
        this.qtMega = qtMega;
        this.valor = valor;
    }

    public Integer getCodigoPlano() {
        return codigoPlano;
    }

    public void setCodigoPlano(Integer codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQtMega() {
        return qtMega;
    }

    public void setQtMega(String qtMega) {
        this.qtMega = qtMega;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPlano != null ? codigoPlano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plano)) {
            return false;
        }
        Plano other = (Plano) object;
        if ((this.codigoPlano == null && other.codigoPlano != null) || (this.codigoPlano != null && !this.codigoPlano.equals(other.codigoPlano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlle.Plano[ codigoPlano=" + codigoPlano + " ]";
    }
    
}
