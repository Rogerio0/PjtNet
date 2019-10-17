/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlle.Controleestoque;

import Controlle.Controleestoque;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gilvan
 */
public class ControleestoqueDao {
    
     //Metodo Salvar os dados 
    public void Salvar(Controleestoque controleestoque ) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.save(controleestoque);
            transaction.commit(); // confirma a transação

        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); // desfaz a transação

            }

        } finally {
            session.close();
        }
    }
    
    // método de excluir 
    public void Excluir(Controleestoque controleestoque ) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.delete(controleestoque);
            transaction.commit(); // confirma a transação

        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); // desfaz a transação

            }

        } finally {
            session.close();
        }
    }
    //Metodo Atualizar os dados 
    public void Atualizar(Controleestoque controleestoque) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            Controleestoque controleestoquesEditar = buscarCodigo(controleestoque.getCodigoProduto());
            controleestoquesEditar.setProdutos(controleestoque.getProdutos());
             session.update(controleestoque);
            transaction.commit(); // confirma a transação

        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); // desfaz a transação

            }

        } finally {
            session.close();
        }
    }
    
    
    
  
    
    
    // método para listar os dados
    public  List< Controleestoque>  listar (){
         Session session = HibernateUtil.getSessionFactory().openSession();
         List<Controleestoque> controleestoqueses =null;
         try{
             Query consulta = session.getNamedQuery("Controleestoque.findAll");
             controleestoqueses = consulta.list();
             
         } catch(RuntimeException ex){
             throw  ex;
         }
         finally{
             session.close();
         }
         return  controleestoqueses;
        
    }
    
    // Buscar por Código
    
     public Controleestoque  buscarCodigo( long  codigo){
         Session session = HibernateUtil.getSessionFactory().openSession();
         Controleestoque controleestoque =null;
         try{
             Query consulta = session.getNamedQuery("Controleestoque.findByCodigoProduto");
             consulta.setLong("codigoProduto", codigo);
             controleestoque =(Controleestoque) consulta.uniqueResult();
             
         } catch(RuntimeException ex){
             throw  ex;
         }
         finally{
             session.close();
         }
         return  controleestoque;
        
    }

    
}
