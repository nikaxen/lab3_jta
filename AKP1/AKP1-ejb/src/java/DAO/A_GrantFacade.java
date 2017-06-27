
package DAO;

import Ent.Grant;
import Entities.Mark;
import Entities.User;
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
public class A_GrantFacade extends AbstractFacade<Grant>{

    @PersistenceContext(unitName = "AKP1-ejbPU")
    private EntityManager em;
    
    //@Resource
    //private SessionContext sc;
    
    @EJB DAO.GrantDAO gDAO;
    
    @EJB dao.GDAO gDAO2;
    
    public A_GrantFacade() {
        super(Grant.class);
    }

    
    
    public void GrantCalculate(String semcode) { 

        Grant grant = gDAO2.getGrantBySemestr(semcode); // Get Grant by Semestr
        
        gDAO.addCustomUser(); // Adding custom user
        gDAO.flush();
        User u = gDAO.getStudent(); // Get student
        
        gDAO2.SetGrant(u.getIdUser(), grant.getIdGrant(), true); // Set grant to student
    }
    
    
    public void Experiment2(String semcode) { 
        
        Grant grant = gDAO2.getGrantBySemestr(semcode); // Get Grant by Semestr
        
        gDAO.addCustomUser2(); // Adding custom user
        gDAO.flush();
        User u = gDAO.getStudent(); // Get student
        
        gDAO2.SetGrantExperiment2(u.getIdUser(), grant.getIdGrant(), true); // Set grant to student
    }
    
    
    public void Experiment3(String semcode) { 
       
        Grant grant = gDAO2.getGrantBySemestr(semcode); // Get Grant by Semestr
        
        gDAO.addCustomUser3(); // Adding custom user 
        gDAO.flush();
        User u = gDAO.getStudent(); // Get student
        
        gDAO2.SetGrantExperiment3(u.getIdUser(), grant.getIdGrant(), true); // Set grant to student
    }
    
   
    public void Experiment4(String semcode) { 
        
        Grant grant = gDAO2.getGrantBySemestr(semcode); // Get Grant by Semestr
        
        gDAO.addCustomUser4(); // Adding custom user
        gDAO.flush();
        User u = gDAO.getStudent(); // Get student
        
        gDAO2.SetGrantExperiment4(u.getIdUser(), grant.getIdGrant(), true); // Set grant to student
    }
    
    
    public void Experiment5(String semcode) { 
   
        Grant grant = gDAO2.getGrantBySemestr(semcode); // Get Grant by Semestr
        
        gDAO.addCustomUser5(); // Adding custom user
        gDAO.flush();
        User u = gDAO.getStudent(); // Get student
        
        gDAO2.SetGrantExperiment5(u.getIdUser(), grant.getIdGrant(), true); // Set grant to student
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
