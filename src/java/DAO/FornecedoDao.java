/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlle.Fornecedo;
import Util.HibernateUtil;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gilvan
 */
public class FornecedoDao {
//Metodo Salvar os dados 
    public void Salvar(Fornecedo fornecedo) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.save(fornecedo);
            transaction.commit(); 

        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); 

            }

        } finally {
            session.close();
        }
    }

    // método de excluir 
    public void Excluir(Fornecedo fornecedo) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.delete(fornecedo);
            transaction.commit(); 

        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); 

            }

        } finally {
            session.close();
        }
    }
//Metodo Atualizar os dados 
    public void Atualizar(Fornecedo fornecedo) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.update(fornecedo);
            transaction.commit(); 

        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); 

            }

        } finally {
            session.close();
        }
    }

    // método para listar os dados
    public List< Fornecedo> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Fornecedo> fornecedoes = null;
        try {
            Query consulta = session.getNamedQuery("Fornecedo.findAll");
            fornecedoes = consulta.list();

        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return fornecedoes;

    }

    // Buscar por Código
    public Fornecedo buscarCodigo(long codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Fornecedo fornecedoes = null;
        try {
    Query consulta = session.getNamedQuery("Fornecedo.findByCodigoFornecedo");
            consulta.setLong("codigoFornecedo", codigo);
            fornecedoes = (Fornecedo) consulta.uniqueResult();

        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return fornecedoes;

    }
}
