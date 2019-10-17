/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlle.Plano;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gilvan
 */
public class PlanoDao {
    //Metodo Salvar os dados 
    public void Salvar(Plano plano ) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.save(plano);
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
    public void Excluir(Plano plano ) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.delete(plano);
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
    public void Atualizar(Plano plano) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            Plano planosEditar = buscarCodigo(plano.getCodigoPlano());
            planosEditar.setNome(plano.getNome());
             session.update(plano);
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
    public  List< Plano>  listar (){
         Session session = HibernateUtil.getSessionFactory().openSession();
         List<Plano> planoses =null;
         try{
             Query consulta = session.getNamedQuery("Plano.findAll");
             planoses = consulta.list();
             
         } catch(RuntimeException ex){
             throw  ex;
         }
         finally{
             session.close();
         }
         return  planoses;
        
    }
    
    // Buscar por Código
    
     public Plano  buscarCodigo( long  codigo){
         Session session = HibernateUtil.getSessionFactory().openSession();
         Plano plano =null;
         try{
             Query consulta = session.getNamedQuery("Plano.findByCodigoPlano");
             consulta.setLong("codigoPlano", codigo);
             plano =(Plano) consulta.uniqueResult();
             
         } catch(RuntimeException ex){
             throw  ex;
         }
         finally{
             session.close();
         }
         return  plano;
        
    }

    
}
