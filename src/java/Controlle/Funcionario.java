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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByCodigoFuncionario", query = "SELECT f FROM Funcionario f WHERE f.codigoFuncionario = :codigoFuncionario"),
    @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionario.findByTelefone", query = "SELECT f FROM Funcionario f WHERE f.telefone = :telefone"),
    @NamedQuery(name = "Funcionario.findByCargo", query = "SELECT f FROM Funcionario f WHERE f.cargo = :cargo"),
    @NamedQuery(name = "Funcionario.findBySalario", query = "SELECT f FROM Funcionario f WHERE f.salario = :salario"),
    @NamedQuery(name = "Funcionario.findByEmail", query = "SELECT f FROM Funcionario f WHERE f.email = :email"),
    @NamedQuery(name = "Funcionario.findByCpf", query = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf"),
    @NamedQuery(name = "Funcionario.findByEstado", query = "SELECT f FROM Funcionario f WHERE f.estado = :estado"),
    @NamedQuery(name = "Funcionario.findByCidade", query = "SELECT f FROM Funcionario f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Funcionario.findByBairro", query = "SELECT f FROM Funcionario f WHERE f.bairro = :bairro"),
    @NamedQuery(name = "Funcionario.findByRua", query = "SELECT f FROM Funcionario f WHERE f.rua = :rua"),
    @NamedQuery(name = "Funcionario.findByNumero", query = "SELECT f FROM Funcionario f WHERE f.numero = :numero")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoFuncionario")
    private Integer codigoFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario")
    private long salario;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "rua")
    private String rua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numero")
    private String numero;
    @OneToMany(mappedBy = "funcionarioidFuncionario")
    private Collection<Servico> servicoCollection;

    public Funcionario() {
    }

    public Funcionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Funcionario(Integer codigoFuncionario, String nome, String telefone, String cargo, long salario, String email, String cpf, String estado, String cidade, String bairro, String rua, String numero) {
        this.codigoFuncionario = codigoFuncionario;
        this.nome = nome;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;
        this.email = email;
        this.cpf = cpf;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public Integer getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    public Collection<Servico> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Servico> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFuncionario != null ? codigoFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codigoFuncionario == null && other.codigoFuncionario != null) || (this.codigoFuncionario != null && !this.codigoFuncionario.equals(other.codigoFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlle.Funcionario[ codigoFuncionario=" + codigoFuncionario + " ]";
    }
    
}
