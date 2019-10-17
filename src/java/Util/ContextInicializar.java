/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * 
 */
public class ContextInicializar implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
      HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
                HibernateUtil.getSessionFactory().close();
    }
    
}
