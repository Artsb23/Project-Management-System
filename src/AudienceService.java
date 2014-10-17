
import javax.persistence.*;
import java.util.*;


/**
*
* @author Lasya
*/

public class AudienceService {
	 private EntityManager manager;
	 
	 public AudienceService(EntityManager manager) {
		 this.manager = manager;
	 }
	 
    // method to create a new record
     public Audience createviewer(String userName, String password, String firstName, String lastName,String email) {
    	Audience viewer = new Audience();
 	    viewer.setUserName(userName);
 	    viewer.setPassword(password);
 	    viewer.setFirstName(firstName);
 	    viewer.setLastName(lastName);
 	   viewer.setEmail(email);
 	    manager.persist(viewer);
 	    return viewer;
     }
    
    // method to read a record
     public Audience readAudience(String userName) {
    	 Audience viewer = manager.find(Audience.class, userName);
    	 return viewer;   	 
     }

     // method to read all records
     public List<Audience> readAll() {
    	 TypedQuery<Audience> query = manager.createQuery("SELECT e FROM Audience e", Audience.class);
    	 List<Audience> result =  query.getResultList();

    	 return result;   	 
     }
     
    // method to update a record
     public Audience updateAudience(String userName, String password, String firstName, String lastName,String email) {
    	 Audience viewer = manager.find(Audience.class, userName);
    	 if (viewer != null) {
    		 viewer.setUserName(userName);
    	 	 viewer.setPassword(password);
    	 	 viewer.setFirstName(firstName);
    	 	 viewer.setLastName(lastName);
    	 	 viewer.setEmail(email);
    	 }
    	 return viewer;
     }

    // method to delete a record
    public void deleteAudience(String userName) {
    	 Audience viewer = manager.find(Audience.class, userName);
    	 if (viewer != null) {
    		 manager.remove(viewer);
    	 }
    }
}

