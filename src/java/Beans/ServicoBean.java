/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controlle.Cliente;
import Controlle.Funcionario;

import Controlle.Servico;
import DAO.ClienteDao;
import DAO.FuncionarioDao;

import DAO.ServicoDao;
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
@ManagedBean(name = "MBServico")
@ViewScoped
public class ServicoBean implements Serializable {

    private Servico servico;

    private ArrayList<Servico> itens;
    private ArrayList<Servico> itensFiltrados;
    private List<Funcionario> listaFuncionario;
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

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    public Servico getServico() {
        if (servico == null) {
            servico = new Servico();
        }
        return servico;
    }

    //
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public ArrayList<Servico> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Servico> itens) {
        this.itens = itens;
    }

    public ArrayList<Servico> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Servico> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
//Metodo para pesquisa de serviço
    //@PostConstruct

    public void prepararPesquisa() {

        try {
            ServicoDao fdao = new ServicoDao();
            itens = (ArrayList<Servico>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//Metodo para Carregar o cadastro de Serviço

    public void carregarCadastro() {

        try {

            if (codigo != null) {

                ServicoDao fdao = new ServicoDao();

                servico = fdao.buscarCodigo(codigo);

            } else {
                servico = new Servico();

            }

            FuncionarioDao dao = new FuncionarioDao();
            listaFuncionario = dao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo para um novo Serviço
    public void novo() {
        servico = new Servico();
    }
//Metodo que salvar os dados de serviço
    public void salvar() {

        try {
            ServicoDao fdao = new ServicoDao();
            fdao.Salvar(servico);

            servico = new Servico();

            JSFUtil.AdicionarMensagemSucesso("Funcionário salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//Metodo que excluir os dados de serviço
    public void excluir() {
        try {
            ServicoDao fdao = new ServicoDao();
            fdao.Excluir(servico);

            JSFUtil.AdicionarMensagemSucesso("Funcionário excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um funcionário que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//Metodo que editar os dados de serviço
    public void editar() {
        try {
            ServicoDao fdao = new ServicoDao();
            fdao.Atualizar(servico);

            JSFUtil.AdicionarMensagemSucesso("Funcionário editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
