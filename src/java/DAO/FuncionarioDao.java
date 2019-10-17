/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlle.Funcionario;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gilvan
 */
public class FuncionarioDao {
    //Metodo Salvar os dados 
    public void Salvar(Funcionario funcionario ) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.save(funcionario);
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
    public void Excluir(Funcionario funcionario ) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            session.delete(funcionario);
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
    public void Atualizar(Funcionario funcionario) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); // Abrindo a transação
            Funcionario funcionariosEditar = buscarCodigo(funcionario.getCodigoFuncionario());
            funcionariosEditar.setNome(funcionario.getNome());
             session.update(funcionario);
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
    public  List< Funcionario>  listar (){
         Session session = HibernateUtil.getSessionFactory().openSession();
         List<Funcionario> funcionarioses =null;
         try{
             Query consulta = session.getNamedQuery("Funcionario.findAll");
             funcionarioses = consulta.list();
             
         } catch(RuntimeException ex){
             throw  ex;
         }
         finally{
             session.close();
         }
         return  funcionarioses;
        
    }
    
    // Buscar por Código
    
     public Funcionario  buscarCodigo( long  codigo){
         Session session = HibernateUtil.getSessionFactory().openSession();
         Funcionario funcionario =null;
         try{
             Query consulta = session.getNamedQuery("Funcionario.findByCodigoFuncionario");
             consulta.setLong("codigoFuncionario", codigo);
             funcionario =(Funcionario) consulta.uniqueResult();
             
         } catch(RuntimeException ex){
             throw  ex;
         }
         finally{
             session.close();
         }
         return  funcionario;
        
    }

    
}
