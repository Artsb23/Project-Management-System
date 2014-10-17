import javax.persistence.*;

import java.io.*;
import java.util.*;

@Entity(name = "project")
public class Project implements Serializable {

  @Column(name = "projName")
  private String projName;
  
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Column
  private String projID;
  
  @Column
  private String fromDate;
  
  @Column
  private String toDate;
  
 @Column
  private String scope;
 
 @Column
 private String status;
 
 @Column
 private String category;
 
@Column
 private String outcome;

@Column
private String lastUpdated;

@Column
private String updatedBy;

  
  /*@ManyToMany(cascade=CascadeType.ALL, mappedBy="projects")
  private Set<People> files;*/
 
  public String getProjectName() {
    return projName;
  }

  public void setProjectName(String name) {
    this.projName = name;
  }

  public String getProjectID() {
    return projID;
  }
  
  public String getProjID() {
	    return projID;
  }
  
  public void setProjID(String num) {
	    this.projID = num;
	  }

  public void setProjectID(String num) {
    this.projID = num;
  }
  
  public String getFromDate() {
	    return fromDate;
   }

   public void setFromDate(String date) {
	    this.fromDate = date;
	}
   
   public String getToDate() {
	    return toDate;
	}
   
   public void setToDate(String date) {
	    this.toDate = date;
	}

   public String getScope() {
	    return scope;
	}
   
   public void setScope(String val) {
	    this.scope = val;
	}
   
   public String getStatus() {
	    return status;
	}
  
  public void setStatus(String val) {
	    this.status = val;
	}
  public String getCategory() {
	    return category;
	}
 
 public void setCategory(String val) {
	    this.category = val;
	}
 public String getOutcome() {
	    return outcome;
	}

public void setOutcome(String val) {
	    this.outcome = val;
	}
public String getLastUpdated() {
    return lastUpdated;
}

public void setLastUpdated(String val) {
    this.lastUpdated = val;
}

public String getUpdatedBy() {
    return updatedBy;
}

public void setUpdatedBy(String val) {
    this.updatedBy = val;
}

   // return number of columns in the table
   public int getNumberOfColumns() {
	   return 10;
   }
   
   /*public void setRecords(Set<People> rec) {
	   people = rec;
   }
   
   public Set<People> getRecords() {
	   return people;
   }*/
   
   // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return getProjectID();
	   else if (i == 1)
		   return getProjectName();
	   else if (i == 2) 
		   return getFromDate();
	   else if (i == 3)
		   return getToDate();
	   else if (i == 4)
		   return getScope();
	   else if (i == 5)
		   return getStatus();
	   else if (i == 6)
		   return getCategory();
	   else if (i == 7)
		   return getOutcome();
	   else if (i == 8)
		   return getLastUpdated();
	   else if (i == 9)
		   return getUpdatedBy();
	   else
		   throw new Exception("Error: invalid column index in courselist table");    
   }
   
   // return the name of column i
   public String getColumnName(int i) throws Exception {
	   String colName = null;
	   if (i == 0) 
		   colName = "projID";
	   else if (i == 1)
		   colName = "projName";
	   else if (i == 2)
		   colName = "fromDate";
	   else if (i == 3)
		   colName = "toDate";
	   else if (i == 4)
		   colName = "scope";
	   else if (i == 5)
		   colName = "status";
	   else if (i == 6)
		   colName = "category";
	   else if (i == 7)
		   colName = "outcome";
	   else if (i == 8)
		   colName = "lastUpdated";
	   else if (i == 9)
		   colName = "updatedBy";
	   else 
		   throw new Exception("Access to invalid column number in courselist table");
	   
	   return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
	   if (i == 0) 
		   projID = (String) value;
	   else if (i == 1) 
		   projName = (String) value;
	   else if (i == 2) 
		   fromDate =  (String) value;
	   else if (i == 3)
		   toDate = (String) value;
	   else if (i == 4)
		   scope = (String) value;
	   else if (i == 5)
			 status = (String) value;
	   else if (i == 6)
			 category = (String) value;
	   else if (i == 7)
			 outcome = (String) value;
	   else if (i == 8)
			 lastUpdated = (String) value;
	   else if (i == 9)
			 updatedBy = (String) value;
	   else
		   throw new Exception("Error: invalid column index in courselist table");    
   }
   
  @Override
  public String toString() {
    return "Project [Project ID =" + projID + ", "
    		+"Project Name =" + projName + ", "
    	    + " From Date =" + fromDate + ","
    	    + " To Date =" + toDate + ","
    	    + " Scope =" + scope + ","
    	    + " Status =" + status + ","
    	    + " Category =" + category + ","
    	    + " Outcome =" + outcome + ","
    	    + " Last Updated =" + lastUpdated + ","
    	    + " Updated By =" + updatedBy + ","
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