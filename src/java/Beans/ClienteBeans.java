/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controlle.Cliente;
import DAO.ClienteDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Rogerio
 */
@ManagedBean
@ViewScoped

public class ClienteBeans implements Serializable {

    private Cliente cliente;
    private ArrayList<Cliente> itens;
    private ArrayList<Cliente> itensFiltrados;
    private String acao;
    private Long codigo;
//get e set
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Cliente getCliente() {
        if (cliente == null) {
            cliente = new Cliente();
        }
        return cliente;
    }

    //
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Cliente> itens) {
        this.itens = itens;
    }

    public ArrayList<Cliente> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Cliente> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }

    //@PostConstruct
    // metodo de pesqusa 
    public void prepararPesquisa() {

        try {
            ClienteDao fdao = new ClienteDao();
            itens = (ArrayList<Cliente>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo para carregar cadastro de cliente
    public void carregarCadastro() {

        try {

            if (codigo != null) {

                ClienteDao fdao = new ClienteDao();

                cliente = fdao.buscarCodigo(codigo);

            } else {
                cliente = new Cliente();

            }
        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo Estanciado novo clente 
    public void novo() {
        cliente = new Cliente();
    }
//Metodo para salvar pos dados de cliente
    public void salvar() {

        try {
            ClienteDao fdao = new ClienteDao();
            fdao.Salvar(cliente);

            cliente = new Cliente();
//mesagem para saber se foi salvo com sucesso
            JSFUtil.AdicionarMensagemSucesso("Clente salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
    //metodo para excluir cliente  se exluido mostra mesagem de sucesso
    public void excluir() {
        try {
            ClienteDao fdao = new ClienteDao();
            fdao.Excluir(cliente);

            JSFUtil.AdicionarMensagemSucesso("Cliente excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um cliente que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//metodo para editar se editado mostra mesagem para o usuario que foi exclido cliente com sucesso
    public void editar() {
        try {
            ClienteDao fdao = new ClienteDao();
            fdao.Atualizar(cliente);

            JSFUtil.AdicionarMensagemSucesso("Cliente editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
