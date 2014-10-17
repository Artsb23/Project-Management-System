
import javax.persistence.*;

import java.io.*;
import java.util.List;

/**
*
* @author Lasya
*/

@Entity(name = "Audience")
public class Audience implements Serializable {

	@Id
  @Column(name = "userName")
  private String userName;
  
  
  @Column
  private String password;
  
 @Column
  private String firstName;
 
 @Column
 private String lastName;
 
 @Column
 private String email;
 
 @Column
 private String role;
  
  public String getUserName() {
    return userName;
  }

  public void setUserName(String name) {
    this.userName = name;
  }
  
  public String getRole() {
	    return role;
	  }

	  public void setRole(String name) {
	    this.role = name;
	  }

  public String getPassword() {
	    return password;
   }

   public void setPassword(String psw) {
	    this.password = psw;
	}
   
   public String getFirstName() {
	    return firstName;
	}
   
   public void setFirstName(String name) {
	    this.firstName = name;
	}

   public String getLastName() {
	    return lastName;
	}
   
   public void setLastName(String name) {
	    this.lastName = name;
	}
   
   public String getEmail() {
	    return email;
	}
  
  public void setEmail(String s) {
	    this.email = s;
	}
   
   // return number of columns in the table
   public int getNumberOfColumns() {
	   return 5;
   }
   
   // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return getUserName();
	   else if (i == 1) 
		   return getPassword();
	   else if (i == 2)
		   return getFirstName();
	   else if (i == 3)
		   return getLastName();
	   else if (i == 4)
		   return getEmail();
	   else if (i == 5)
		   return getRole();
	   else
		   throw new Exception("Error: invalid column index in Audience table");    
   }
   
   // return the name of column i
   public String getColumnName(int i) throws Exception {
	   String colName = null;
	   if (i == 0) 
		   colName = "userName";
	  else if (i == 1)
		   colName = "password";
	   else if (i == 2)
		   colName = "firstName";
	   else if (i == 3)
		   colName = "lastName";
	   else if (i == 4)
		   colName = "email";
	   else if (i == 5)
		   colName = "role";
	   else 
		   throw new Exception("Access to invalid column number in Audience table");
	   
	   return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
	   if (i == 0) 
		   userName = (String) value;
	   else if (i == 1) 
		   password = (String) value;
	   else if (i == 2)
		   firstName = (String) value;
	   else if (i == 3)
		  lastName = (String) value;
	   else if (i == 4)
		  email = (String) value;
	   else if (i == 5)
			  role = (String) value;
	   else
		   throw new Exception("Error: invalid column index in Audience table");    
   }
   
  @Override
  public String toString() {
    return "Audience [ User Name =" + userName + ","
    	    + " Password =" + password + ","
    	    + " First Name =" + firstName + ","
    	    + " Last Name =" + lastName + ","
    	    + " Email =" + email + ","
    	    + " Role =" + role + ","
        + "]";
  }

  
  public static void main(String[] args)
  {
			factory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
			EntityManager manager = factory.createEntityManager();
			
			EntityTransaction transaction =manager.getTransaction();
			TypedQuery<Object> query = manager.createQuery("SELECT COUNT(c) FROM Audience c where c.userName='Lpriya'", Object.class);
			transaction.begin();
			List<Object> result = query.getResultList();
			transaction.commit();

			for (Object data : result)
				System.out.println(data);
			transaction.begin();
			transaction.commit();
			LGui = new LoginGUI();
		    LGui.showGUI();
  
  }

		private static final String PERSISTANCE_UNIT_NAME = "PersistenceUnit";
		private static EntityManagerFactory factory;
		public static LoginGUI LGui;
} 

