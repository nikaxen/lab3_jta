
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
    
    @Resource
    SessionContext sc;
    
    @EJB DAO.GrantDAO gDAO;
    
    @EJB dao.GDAO gDAO2;
    
    public A_GrantFacade() {
        super(Grant.class);
    }

    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void GrantCalculate(String semcode) { 

        gDAO2.CleanGrants(semcode);

        Grant grant = gDAO2.getGrantBySemestr(semcode);
        
        List<User> uList = gDAO.getUserList(semcode);
        boolean grant_status = true;
        for (User u : uList) {
            List<Mark> markList = u.getMarkList();
            for (Mark m : markList) {
                if (u.getIdUser() == m.getUser().getIdUser()) {
                    System.out.println(u.getFio() + " - " + m.getMark());
                    if (m.getMark() < 4) {
                        grant_status = false;
                    }
                }
            }

            gDAO2.SetGrant(u.getIdUser(), grant.getIdGrant(), grant_status);
            grant_status = true;
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Experiment2(String semcode) { 
        gDAO2.CleanGrants(semcode);

        Grant grant = gDAO2.getGrantBySemestr(semcode);

        
        List<User> uList = gDAO.getUserList(semcode);
        boolean grant_status = true;
        for (User u : uList) {
            List<Mark> markList = u.getMarkList();
            for (Mark m : markList) {
                if (u.getIdUser() == m.getUser().getIdUser()) {
                    System.out.println(u.getFio() + " - " + m.getMark());
                    if (m.getMark() < 4) {
                        grant_status = false;
                    }
                }
            }

            gDAO2.SetGrantExperiment2(u.getIdUser(), grant.getIdGrant(), grant_status);
            grant_status = true;
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Experiment3(String semcode) { 
        gDAO2.CleanGrants(semcode);

        Grant grant = gDAO2.getGrantBySemestr(semcode);

        
        List<User> uList = gDAO.getUserList(semcode);
        boolean grant_status = true;
        for (User u : uList) {
            List<Mark> markList = u.getMarkList();
            for (Mark m : markList) {
                if (u.getIdUser() == m.getUser().getIdUser()) {
                    System.out.println(u.getFio() + " - " + m.getMark());
                    if (m.getMark() < 4) {
                        grant_status = false;
                    }
                }
            }
            
            
            gDAO2.SetGrant(u.getIdUser(), grant.getIdGrant(), grant_status); 
            grant_status = true;
        }
        sc.setRollbackOnly(); // ROLLBACK
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void Experiment4(String semcode) { 
        try {
            gDAO2.CleanGrants(semcode);

            Grant grant = gDAO2.getGrantBySemestr(semcode);

            
            List<User> uList = gDAO.getUserList(semcode);
            boolean grant_status = true;
            for (User u : uList) {
                List<Mark> markList = u.getMarkList();
                for (Mark m : markList) {
                    if (u.getIdUser() == m.getUser().getIdUser()) {
                        System.out.println(u.getFio() + " - " + m.getMark());
                        if (m.getMark() < 4) {
                            grant_status = false;
                        }
                    }
                }
                
                gDAO2.SetGrantExperiment4(u.getIdUser(), grant.getIdGrant(), grant_status); 
                grant_status = true;
            }
            sc.setRollbackOnly(); // ROLLBACK
        } catch (Exception ex) {
            System.out.println("Exception = " + ex);
        }
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void Experiment5(String semcode) { 
    try {
            gDAO2.CleanGrants(semcode);

            Grant grant = gDAO2.getGrantBySemestr(semcode);

            
            List<User> uList = gDAO.getUserList(semcode);
            boolean grant_status = true;
            for (User u : uList) {
                List<Mark> markList = u.getMarkList();
                for (Mark m : markList) {
                    if (u.getIdUser() == m.getUser().getIdUser()) {
                        System.out.println(u.getFio() + " - " + m.getMark());
                        if (m.getMark() < 4) {
                            grant_status = false;
                        }
                    }
                }
                
                gDAO2.SetGrantExperiment4(u.getIdUser(), grant.getIdGrant(), grant_status); 
                grant_status = true;
            }
        } catch (Exception ex) {
            System.out.println("Exception = " + ex);
        }
        sc.setRollbackOnly(); // ROLLBACK
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
