/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlle.Instalacao;
import Util.HibernateUtil;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gilvan
 */
public class InstalacaoDao {
//Metodo Salvar os dados 
    public void Salvar(Instalacao instalacao) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.save(instalacao);
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
    public void Excluir(Instalacao instalacao) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.delete(instalacao);
            transaction.commit(); 

        } catch (RuntimeException ex) {
            if (transaction != null) {
                transaction.rollback(); 

            }

        } finally {
            session.close();
        }
    }
//Metodo Atualiza os dados 
    public void Atualizar(Instalacao instalacao) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction(); 
            session.update(instalacao);
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
    public List< Instalacao> listar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Instalacao> instalacaoes = null;
        try {
            Query consulta = session.getNamedQuery("Instalacao.findAll");
            instalacaoes = consulta.list();

        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return instalacaoes;

    }

    // Buscar por Código
    public Instalacao buscarCodigo(long codigo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Instalacao instalacaoes = null;
        try {
    Query consulta = session.getNamedQuery("Instalacao.findByCodigoInstalacao");
            consulta.setLong("codigoInstalacao", codigo);
            instalacaoes = (Instalacao) consulta.uniqueResult();

        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            session.close();
        }
        return instalacaoes;

    }
}
