
package dao;

import Ent.Grant;
import Ent.GrantUser;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GDAOImpl implements GDAO, Serializable{
    @PersistenceContext(unitName = "AKP1-Grants-ejbPU")
    private EntityManager em2;
    
    @Override
    public List<GrantUser> getGrantDetails(String semcode) {
        Query query = em2.createQuery("SELECT gu FROM GrantUser gu JOIN gu.grant gr WHERE gr.grantSemestr=?1", GrantUser.class);
        query.setParameter(1, semcode);
        return (List<GrantUser>) query.getResultList();
    }
    
    @Override
    public Grant getGrantBySemestr(String semcode){
        Query query_grant = em2.createQuery("SELECT g FROM Grant g WHERE g.grantSemestr=?1", Grant.class);
        query_grant.setParameter(1, semcode);
        return (Grant) query_grant.getSingleResult();
    }
    
    @Override
    public List<Grant> getAllGrants() {
        Query query = em2.createQuery("SELECT g FROM Grant g", Grant.class);
        return (List<Grant>) query.getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    @Override
    public void SetGrant(int id_user, int id_grant, boolean grant_status){
        Grant g = em2.find(Grant.class, id_grant);
        GrantUser gu = new GrantUser();
        
        gu.setIdUser(id_user);
        gu.setGrant(g);
        if (grant_status) {
        System.out.println("ПОЛУЧАЕТ - " + id_user);
        gu.setGrantStatus("ok");
        } else {
        System.out.println("НЕ ПОЛУЧАЕТ - " + id_user);
        gu.setGrantStatus("no");
        }
        em2.merge(gu);
    }

    
    // lab3
    
    
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    @Override
    public void SetGrantExperiment2(int id_user, int id_grant, boolean grant_status){
        Grant g = em2.find(Grant.class, id_grant);
        GrantUser gu = new GrantUser();
        
        gu.setIdUser(id_user);
        gu.setGrant(g);
        if (grant_status) {
        System.out.println("ПОЛУЧАЕТ - " + id_user);
        gu.setGrantStatus("ok");
        } else {
        System.out.println("НЕ ПОЛУЧАЕТ - " + id_user);
        gu.setGrantStatus("no");
        }
        em2.merge(gu);
        throw new EJBException("SetGrantExperiment2 Exception in AKP1-Grants-ejb!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void SetGrantExperiment4(int id_user, int id_grant, boolean grant_status){
        Grant g = em2.find(Grant.class, id_grant);
        GrantUser gu = new GrantUser();
        
        gu.setIdUser(id_user);
        gu.setGrant(g);
        if (grant_status) {
        System.out.println("ПОЛУЧАЕТ - " + id_user);
        gu.setGrantStatus("ok");
        } else {
        System.out.println("НЕ ПОЛУЧАЕТ - " + id_user);
        gu.setGrantStatus("no");
        }
        em2.merge(gu);
    }
    
    
    // end of lab3
    
    @Override
    public void AddNewGrant(String grant_semestr, String grant_title) {
        Grant g = new Grant();
        g.setGrantSemestr(grant_semestr);
        g.setGrantTitle(grant_title);
        em2.persist(g);
    }

    @Override
    public void CleanGrants(String semcode) {
        Query query = em2.createQuery("DELETE FROM GrantUser gu WHERE gu.grant.grantSemestr=?1", GrantUser.class);
        query.setParameter(1, semcode);
        query.executeUpdate();
    }
}
