
package DAO;

import Ent.Grant;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GrantDAO {
    public void GrantCalculate(String semcode);
    public List<Grant> getAllGrants();
    // lab3
    public void Experiment2(String semcode);
    public void Experiment3(String semcode);
    public void Experiment4(String semcode);
    public void Experiment5(String semcode);  // end of lab3
}
