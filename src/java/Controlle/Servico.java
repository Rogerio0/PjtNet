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
@Table(name = "servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findByCodigoServico", query = "SELECT s FROM Servico s WHERE s.codigoServico = :codigoServico"),
    @NamedQuery(name = "Servico.findByDescricaoServico", query = "SELECT s FROM Servico s WHERE s.descricaoServico = :descricaoServico"),
    @NamedQuery(name = "Servico.findByValor", query = "SELECT s FROM Servico s WHERE s.valor = :valor"),
    @NamedQuery(name = "Servico.findByData", query = "SELECT s FROM Servico s WHERE s.data = :data")})
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoServico")
    private Integer codigoServico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao_Servico")
    private String descricaoServico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private long valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "codigoCliente")
    @ManyToOne
    private Cliente clienteidCliente;
    @JoinColumn(name = "Funcionario_idFuncionario", referencedColumnName = "codigoFuncionario")
    @ManyToOne
    private Funcionario funcionarioidFuncionario;

    public Servico() {
    }

    public Servico(Integer codigoServico) {
        this.codigoServico = codigoServico;
    }

    public Servico(Integer codigoServico, String descricaoServico, long valor, Date data) {
        this.codigoServico = codigoServico;
        this.descricaoServico = descricaoServico;
        this.valor = valor;
        this.data = data;
    }

    public Integer getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(Integer codigoServico) {
        this.codigoServico = codigoServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public Funcionario getFuncionarioidFuncionario() {
        return funcionarioidFuncionario;
    }

    public void setFuncionarioidFuncionario(Funcionario funcionarioidFuncionario) {
        this.funcionarioidFuncionario = funcionarioidFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoServico != null ? codigoServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.codigoServico == null && other.codigoServico != null) || (this.codigoServico != null && !this.codigoServico.equals(other.codigoServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlle.Servico[ codigoServico=" + codigoServico + " ]";
    }
    
}
