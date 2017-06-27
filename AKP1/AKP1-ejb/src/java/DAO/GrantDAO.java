
package DAO;

import Ent.Grant;
import Entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GrantDAO {
    //public void GrantCalculate(String semcode);
    public User getStudent();
    public List<Grant> getAllGrants();
    public void addCustomUser();
    public void addCustomUser2();
    public void addCustomUser3();
    public void addCustomUser4();
    public void addCustomUser5();
    public void flush();
   
}
