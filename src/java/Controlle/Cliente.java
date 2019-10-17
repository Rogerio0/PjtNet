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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCodigoCliente", query = "SELECT c FROM Cliente c WHERE c.codigoCliente = :codigoCliente"),
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cliente.findByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
    @NamedQuery(name = "Cliente.findByEstado", query = "SELECT c FROM Cliente c WHERE c.estado = :estado"),
    @NamedQuery(name = "Cliente.findByCidade", query = "SELECT c FROM Cliente c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "Cliente.findByBairro", query = "SELECT c FROM Cliente c WHERE c.bairro = :bairro"),
    @NamedQuery(name = "Cliente.findByRua", query = "SELECT c FROM Cliente c WHERE c.rua = :rua"),
    @NamedQuery(name = "Cliente.findByNumero", query = "SELECT c FROM Cliente c WHERE c.numero = :numero")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoCliente")
    private Integer codigoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "telefone")
    private String telefone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "rua")
    private String rua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numero")
    private String numero;
    @OneToMany(mappedBy = "clientecodigoCliente")
    private Collection<Instalacao> instalacaoCollection;
    @OneToMany(mappedBy = "clienteidCliente")
    private Collection<Plano> planoCollection;
    @OneToMany(mappedBy = "clienteidCliente")
    private Collection<Servico> servicoCollection;

    public Cliente() {
    }

    public Cliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Cliente(Integer codigoCliente, String nome, String telefone, String email, String estado, String cidade, String bairro, String rua, String numero) {
        this.codigoCliente = codigoCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @XmlTransient
    public Collection<Instalacao> getInstalacaoCollection() {
        return instalacaoCollection;
    }

    public void setInstalacaoCollection(Collection<Instalacao> instalacaoCollection) {
        this.instalacaoCollection = instalacaoCollection;
    }

    @XmlTransient
    public Collection<Plano> getPlanoCollection() {
        return planoCollection;
    }

    public void setPlanoCollection(Collection<Plano> planoCollection) {
        this.planoCollection = planoCollection;
    }

    @XmlTransient
    public Collection<Servico> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Servico> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCliente != null ? codigoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codigoCliente == null && other.codigoCliente != null) || (this.codigoCliente != null && !this.codigoCliente.equals(other.codigoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlle.Cliente[ codigoCliente=" + codigoCliente + " ]";
    }
    
}
