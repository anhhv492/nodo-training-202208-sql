package edu.hanoi.service.dao.impl;

import edu.hanoi.service.dao.UserDAO;
import edu.hanoi.service.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.SessionScope;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    private LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

    @Qualifier("sessionFactoryBean")
    public void setSessionFactoryBean(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactoryBean = sessionFactory;
    }

    @Override
    public List<User> list(){
        EntityManager session = null;
        try {
            Query query = session.createQuery("select u from User u");
            return query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
