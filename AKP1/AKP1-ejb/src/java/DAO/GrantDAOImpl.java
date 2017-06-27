package DAO;

import Ent.Grant;
import Entities.Mark;
import Entities.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GrantDAOImpl implements GrantDAO, Serializable {

    @PersistenceContext(unitName = "AKP1-ejbPU")
    private EntityManager em;

    @EJB
    private dao.GDAO gDAO2;
    
    @EJB private DAO.UserDAO uDAO;
    
    @Resource
    private SessionContext sc;

    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void addCustomUser(){
        uDAO.RegisterUser("custom user", "jta@mail.ru", "11");
    }
    
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void addCustomUser2(){
        uDAO.RegisterUser("custom user", "jta@mail.ru", "11");
    }
    
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void addCustomUser3(){
        uDAO.RegisterUser("custom user", "jta@mail.ru", "11");
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public void addCustomUser4(){
        uDAO.RegisterUser("custom user", "jta@mail.ru", "11");
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public void addCustomUser5(){
        uDAO.RegisterUser("custom user", "jta@mail.ru", "11");
    }
    
    @Override
    public User getStudent() {
        return em.find(User.class, 1);
    }

    
    @Override
    public void flush() {
        em.flush();
    }

    @Override
    public List<Grant> getAllGrants() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
