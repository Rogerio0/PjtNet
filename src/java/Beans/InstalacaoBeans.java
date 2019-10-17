/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controlle.Cliente;
import Controlle.Instalacao;
import DAO.ClienteDao;
import DAO.InstalacaoDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Gilvan
 */
@ManagedBean
@ViewScoped

public class InstalacaoBeans implements Serializable {

    private Instalacao instalacao;

    private ArrayList<Instalacao> itens;
    private ArrayList<Instalacao> itensFiltrados;
     private List<Cliente>ListaCliente;

    public List<Cliente> getListaCliente() {
        return ListaCliente;
    }

    public void setListaCliente(List<Cliente> ListaCliente) {
        this.ListaCliente = ListaCliente;
    }
    private String acao;
    private Long codigo;

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

    public Instalacao getInstalacao() {
        if (instalacao == null) {
            instalacao = new Instalacao();
        }
        return instalacao;
    }

    //
    public void setInstalacao(Instalacao instalacao) {
        this.instalacao = instalacao;
    }

    public ArrayList<Instalacao> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Instalacao> itens) {
        this.itens = itens;
    }

    public ArrayList<Instalacao> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Instalacao> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
//metodo de pesquisa a instalação
    //@PostConstruct
    public void prepararPesquisa() {

        try {
            InstalacaoDao fdao = new InstalacaoDao();
            itens = (ArrayList<Instalacao>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de carregar o cadastro de instalacao
    public void carregarCadastro() {

         try {

            if (codigo != null) {

                InstalacaoDao fdao = new InstalacaoDao();

                instalacao = fdao.buscarCodigo(codigo);

            } else {
                instalacao = new Instalacao();

            }

            ClienteDao dao = new ClienteDao();
            ListaCliente = dao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo nova instalação
    public void novo() {
        instalacao = new Instalacao();
    }
//metodo para salvar os dados do formulário de instalaçãp
    public void salvar() {

        try {
            InstalacaoDao fdao = new InstalacaoDao();
            fdao.Salvar(instalacao);

            instalacao = new Instalacao();

            JSFUtil.AdicionarMensagemSucesso("Instalação salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//metodo para excluir o objeto instalacao
    public void excluir() {
        try {
            InstalacaoDao fdao = new InstalacaoDao();
            fdao.Excluir(instalacao);

            JSFUtil.AdicionarMensagemSucesso("Instalação excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um instalação que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
// metodo para edita a instalação
    public void editar() {
        try {
            InstalacaoDao fdao = new InstalacaoDao();
            fdao.Atualizar(instalacao);

            JSFUtil.AdicionarMensagemSucesso("Instalação editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
