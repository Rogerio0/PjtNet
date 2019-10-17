/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Gilvan
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            
            Configuration configuration =new  Configuration();
            configuration.configure();
            
      ServiceRegistry serviceRegistry = new  StandardServiceRegistryBuilder().
              applySettings(configuration.getProperties()).build();
            
    SessionFactory sessionFactory = configuration.buildSessionFactory
        (serviceRegistry);
            return sessionFactory;
            
         
        }
        catch (Throwable ex) {
            
            //Mensagem de erro ao conectar
            System.err.println("Erro na Conexao com Banco de dados" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
