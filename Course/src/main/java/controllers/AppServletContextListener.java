package controllers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.InMemoryCategoryDao;
import dao.InMemoryUserDao;
import database.TestDataBase;

@WebListener
public class AppServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("userDao", new InMemoryUserDao());
        InMemoryCategoryDao categoryDao = new InMemoryCategoryDao();
        TestDataBase.create(categoryDao);
        sce.getServletContext().setAttribute("categoryDao", new InMemoryCategoryDao());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
