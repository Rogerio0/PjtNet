/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import Controlle.Fornecedo;
import DAO.FornecedoDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Gilvan
 */
@ManagedBean(name = "MBFornecedo")
@ViewScoped
public class FornecedoBean implements Serializable {

   
    private Fornecedo fornecedo;

    private ArrayList<Fornecedo> itens;
    private ArrayList<Fornecedo> itensFiltrados;
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

    public Fornecedo getFornecedo() {
        if (fornecedo == null) {
            fornecedo = new Fornecedo();
        }
        return fornecedo;
    }

    //
    public void setFornecedo(Fornecedo fornecedo) {
        this.fornecedo = fornecedo;
    }

    public ArrayList<Fornecedo> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Fornecedo> itens) {
        this.itens = itens;
    }

    public ArrayList<Fornecedo> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Fornecedo> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }

    //@PostConstruct
    //metodo para pesquisa
    public void prepararPesquisa() {

        try {
            FornecedoDao fdao = new FornecedoDao();
            itens = (ArrayList<Fornecedo>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo para caregar o cadastro de fornecedor
    public void carregarCadastro() {

       
          try {

            if (codigo != null) {

                FornecedoDao fdao = new FornecedoDao();

                fornecedo = fdao.buscarCodigo(codigo);

            } else {
                fornecedo = new Fornecedo();

            }

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo para novo fornecedor
    public void novo() {
        fornecedo = new Fornecedo();
    }

    public void salvar() {

        try {
            FornecedoDao fdao = new FornecedoDao();
            fdao.Salvar(fornecedo);

            fornecedo = new Fornecedo();

            JSFUtil.AdicionarMensagemSucesso("Fornecedor salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//metodo para escluir
    public void excluir() {
        try {
            FornecedoDao fdao = new FornecedoDao();
            fdao.Excluir(fornecedo);

            JSFUtil.AdicionarMensagemSucesso("Fornecedor excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um fornecedor que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//metodo para editar fornecedor
    public void editar() {
        try {
            FornecedoDao fdao = new FornecedoDao();
            fdao.Atualizar(fornecedo);

            JSFUtil.AdicionarMensagemSucesso("Fonecedor editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
