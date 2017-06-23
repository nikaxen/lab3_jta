package Ent;

import Ent.GrantUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-23T19:27:34")
@StaticMetamodel(Grant.class)
public class Grant_ { 

    public static volatile SingularAttribute<Grant, Integer> idGrant;
    public static volatile SingularAttribute<Grant, String> grantTitle;
    public static volatile ListAttribute<Grant, GrantUser> grantUserList;
    public static volatile SingularAttribute<Grant, String> grantSemestr;

}