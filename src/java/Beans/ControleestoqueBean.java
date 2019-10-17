/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;





import Controlle.Fornecedo;
import Controlle.Controleestoque;
import DAO.ControleestoqueDao;
import DAO.FornecedoDao;
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
@ManagedBean(name = "MBControleestoque")
@ViewScoped
public class ControleestoqueBean implements Serializable {
 private Controleestoque controleestoque;

    private ArrayList<Controleestoque> itens;
    private ArrayList<Controleestoque> itensFiltrados;
    private List<Fornecedo>ListaFornecedo;

    public List<Fornecedo> getListaFornecedo() {
        return ListaFornecedo;
    }

    public void setListaFornecedo(List<Fornecedo> ListaFornecedo) {
        this.ListaFornecedo = ListaFornecedo;
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

    public Controleestoque getControleestoque() {
        if (controleestoque == null) {
            controleestoque = new Controleestoque();
        }
        return controleestoque;
    }

    //
    public void setControleestoque(Controleestoque controleestoque) {
        this.controleestoque = controleestoque;
    }

    public ArrayList<Controleestoque> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Controleestoque> itens) {
        this.itens = itens;
    }

    public ArrayList<Controleestoque> getItensFiltrados() {
        return itensFiltrados;
    }

    public void setItensFiltrados(ArrayList<Controleestoque> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
//metodo para pesquisar  controleestoque 
    //@PostConstruct
    public void prepararPesquisa() {

        try {
            ControleestoqueDao fdao = new ControleestoqueDao();
            itens = (ArrayList<Controleestoque>) fdao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo para caregar cadastro 
    public void carregarCadastro() {

       

          try {

            if (codigo != null) {

                ControleestoqueDao fdao = new ControleestoqueDao();

                controleestoque = fdao.buscarCodigo(codigo);

            } else {
                controleestoque = new Controleestoque();

            }

            FornecedoDao dao = new FornecedoDao();
            ListaFornecedo= dao.listar();

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
//metodo para um novo controleestoque 
    public void novo() {
        controleestoque = new Controleestoque();
    }
//metodo de salva controle estoque 
    public void salvar() {

        try {
            ControleestoqueDao fdao = new ControleestoqueDao();
            fdao.Salvar(controleestoque);

            controleestoque = new Controleestoque();

            JSFUtil.AdicionarMensagemSucesso("Produto salvo com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }
//metodo para escluir os dados  de tever sucesso mostra mesagem para o usuário
    public void excluir() {
        try {
            ControleestoqueDao fdao = new ControleestoqueDao();
            fdao.Excluir(controleestoque);

            JSFUtil.AdicionarMensagemSucesso("Produto excluido com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("Não é possível excluir um Produto que tenha uma venda associado!");
            e.printStackTrace();
        }
    }
//metodo para editar 
    public void editar() {
        try {
            ControleestoqueDao fdao = new ControleestoqueDao();
            fdao.Atualizar(controleestoque);

            JSFUtil.AdicionarMensagemSucesso("Produto editado com sucesso!");

        } catch (RuntimeException e) {
            JSFUtil.AdicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }
    }

}
