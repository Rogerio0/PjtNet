/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controlle.Funcionario;
import DAO.FuncionarioDao;
import Util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Gilvan
 */
@ManagedBean(name = "MBFuncionarios")
@ViewScoped
public class FuncionariosBean implements Serializable {

    private Funcionario funcionario;

    private ArrayList<Funcionario> itens;
    private ArrayList<Funcionario> itensFiltrados;
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

    public Funcionario getFuncionario() {
       if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionario;
    }

    //
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Funcionario> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Funcionario> itens) {
        this.itens = itens;
    }

    public ArrayList<Funcionario> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Funcionario> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
//metodo para pesquisa funcionario
    //@PostConstruct
    public void prepararPesquisa() {

        try {
            FuncionarioDao fdao = new FuncionarioDao();
            itens = (ArrayList<Funcionario>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo de carregar o cadastro de funcionario
    public void carregarCadastro() {

        try {

            if (codigo != null) {

                FuncionarioDao fdao = new FuncionarioDao();

                funcionario = fdao.buscarCodigo(codigo);

            } else {
                funcionario = new Funcionario();

            }

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo para criar um novo objeto funcionario
    public void novo() {
        funcionario = new Funcionario();
    }
//metodo para salvar o objeto funcionario
    public void salvar() {

        try {
            FuncionarioDao fdao = new FuncionarioDao();
            fdao.Salvar(funcionario);

            funcionario = new Funcionario();

            JSFUtil.AdicionarMensagemSucesso("Funcionário salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//metodo para excluir o funcionario
    public void excluir() {
        try {
            FuncionarioDao fdao = new FuncionarioDao();
            fdao.Excluir(funcionario);

            JSFUtil.AdicionarMensagemSucesso("Funcionário excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um funcionário que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//metodo para editar o funcinario
    public void editar() {
        try {
            FuncionarioDao fdao = new FuncionarioDao();
            fdao.Atualizar(funcionario);

            JSFUtil.AdicionarMensagemSucesso("Funcionário editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
