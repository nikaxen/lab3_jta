
package dao;

import Ent.Grant;
import Ent.GrantUser;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GDAO {
    public List<GrantUser> getGrantDetails(String semcode);
    public void AddNewGrant(String grant_semestr, String grant_title);
    public List<Grant> getAllGrants();
    public Grant getGrantBySemestr(String semcode);
    public void SetGrant(int id_user, int id_grant, boolean status);
    public void CleanGrants(String semcode);
    public void flush();
    public void SetGrantExperiment2(int id_user, int id_grant, boolean status);
    public void SetGrantExperiment3(int id_user, int id_grant, boolean status);
    public void SetGrantExperiment4(int id_user, int id_grant, boolean status);
    public void SetGrantExperiment5(int id_user, int id_grant, boolean status);
}
