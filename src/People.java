import javax.persistence.*;

import java.io.*;
import java.util.*;

@Entity(name = "project_people")
public class People implements Serializable {

  @Column(name = "name")
  private String name;
  
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Column
  private String personID;
  
  @Column
  private String projectID;
  
  @Column
  private String role;
  
  
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getPersonID() {
	    return personID;
	  }

	  public void setPersonID(String num) {
	    this.personID = num;
	  }

  public String getProjectID() {
    return projectID;
  }

  public void setProjectID(String num) {
    this.projectID = num;
  }
  

   public String getRole() {
	    return role;
	}
   
   public void setRole(String val) {
	    this.role = val;
	}

   // return number of columns in the table
   public int getNumberOfColumns() {
	   return 4;
   }
   
   // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return getPersonID();
	   else if (i == 1)
		   return getName();
	   else if (i == 2) 
		   return getProjectID();
	   else if (i == 3)
		   return getRole();
	   else
		   throw new Exception("Error: invalid column index in courselist table");    
   }
   
   // return the name of column i
   public String getColumnName(int i) throws Exception {
	   String colName = null;
	   if (i == 0) 
		   colName = "personID";
	   else if (i == 1)
		   colName = "name";
	   else if (i == 2)
		   colName = "projectID";
	   else if (i == 3)
		   colName = "role";
	   else 
		   throw new Exception("Access to invalid column number in courselist table");
	   
	   return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
	   if (i == 0) 
		   personID = (String) value;
	   else if (i == 1) 
		   name = (String) value;
	   else if (i == 2) 
		   projectID =  (String) value;
	   else if (i == 3)
		   role = (String) value;
	   else
		   throw new Exception("Error: invalid column index in courselist table");    
   }
   
  @Override
  public String toString() {
    return "People [Person ID =" + personID + ", "
    		+ " Name =" + name + ", "
    	    + " Project ID =" + projectID + ","
    	    + " Role =" + role + ","
        + "]";
  }
  
  public static void main(String[] args)
  {
	  /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		TypedQuery<Object> query = manager.createQuery("SELECT COUNT(c) FROM project c where c.status='Started'", Object.class);
		
		transaction.begin();
		List<Object> result = query.getResultList();
		transaction.commit();*/

		/*for (Object data : result)
			System.out.println(data);*/

  
  }

} 