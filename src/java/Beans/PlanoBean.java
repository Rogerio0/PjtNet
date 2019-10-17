/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Controlle.Cliente;
import DAO.ClienteDao;
import Controlle.Plano;
import DAO.PlanoDao;
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
@ManagedBean(name = "MBPlano")
@ViewScoped
public class PlanoBean implements Serializable {

    private Plano plano;

    private ArrayList<Plano> itens;
    private ArrayList<Plano> itensFiltrados;
    private List<Cliente> ListaCliente;

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

    public Plano getPlano() {
        if (plano == null) {
            plano = new Plano();
        }
        return plano;
    }

    //
    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public ArrayList<Plano> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Plano> itens) {
        this.itens = itens;
    }

    public ArrayList<Plano> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Plano> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
//Metodo para pesquisar Plano
    //@PostConstruct

    public void prepararPesquisa() {

        try {
            PlanoDao fdao = new PlanoDao();
            itens = (ArrayList<Plano>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//Metodo para carega Dados do objeto Plano

    public void carregarCadastro() {

        try {

            if (codigo != null) {

                PlanoDao fdao = new PlanoDao();

                plano = fdao.buscarCodigo(codigo);

            } else {
                plano = new Plano();

            }

            ClienteDao dao = new ClienteDao();
            ListaCliente = dao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//Metodo para novo Plano
    public void novo() {
        plano = new Plano();
    }

    public void salvar() {

        try {
            PlanoDao fdao = new PlanoDao();
            fdao.Salvar(plano);

            plano = new Plano();

            JSFUtil.AdicionarMensagemSucesso("Plano salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//Metodo  para excluir dados de plano
    public void excluir() {
        try {
            PlanoDao fdao = new PlanoDao();
            fdao.Excluir(plano);

            JSFUtil.AdicionarMensagemSucesso("Plano excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um funcionário que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//Metodo que edita os dados de Plano
    public void editar() {
        try {
            PlanoDao fdao = new PlanoDao();
            fdao.Atualizar(plano);

            JSFUtil.AdicionarMensagemSucesso("Plano editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
