/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlle.Cliente;
import Util.HibernateUtil;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gilvan
 */
public class ClienteDao {
//metodo Salvar
    public void Salvar(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.save(cliente);
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
    public void Excluir(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.delete(cliente);
            transaction.commit(); 

        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); 

            }

        } finally {
            session.close();
        }
    }
//metodo Atualizar
    public void Atualizar(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.update(cliente);
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
    public List< Cliente> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> clientees = null;
        try {
            Query consulta = session.getNamedQuery("Cliente.findAll");
            clientees = consulta.list();

        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return clientees;

    }

    // Buscar por Código
    public Cliente buscarCodigo(long codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente clientees = null;
        try {
    Query consulta = session.getNamedQuery("Cliente.findByCodigoCliente");
            consulta.setLong("codigoCliente", codigo);
            clientees = (Cliente) consulta.uniqueResult();

        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return clientees;

    }
}
