import javax.persistence.*;

import java.io.*;
import java.util.*;

@Entity(name = "project_files")
public class Files implements Serializable {

  @Column(name = "fileName")
  private String fileName;
  
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @Column
  private String fileID;
  
  @Column
  private String projID;
  
  @Column
  private String format;
  
 @Column
  private String location;
 
  public String getFileName() {
    return fileName;
  }

  public void setFileName(String name) {
    this.fileName = name;
  }
  
  public String getFileID() {
	    return fileID;
	  }

	  public void setFileID(String num) {
	    this.fileID = num;
	  }

  public String getProjectID() {
    return projID;
  }

  public void setProjectID(String num) {
    this.projID = num;
  }
  public String getProjID() {
		return projID;
	}

	public void setProjID(String projID) {
		this.projID = projID;
	}

   public String getFormat() {
	    return format;
	}
   
   public void setFormat(String val) {
	    this.format = val;
	}
   
   public String getLocation() {
	    return location;
	}
  
  public void setLocation(String val) {
	    this.location = val;
	}

   // return number of columns in the table
   public int getNumberOfColumns() {
	   return 5;
   }
   
   // return the data in column i
   public String getColumnData(int i) throws Exception {
	   if (i == 0)
		   return getFileID();
	   else if (i == 1)
		   return getProjectID();
	   else if (i == 2) 
		   return getFormat();
	   else if (i == 3)
		   return getFileName();
	   else if (i == 4)
		   return getLocation();
	   else
		   throw new Exception("Error: invalid column index in courselist table");    
   }
   
   // return the name of column i
   public String getColumnName(int i) throws Exception {
	   String colName = null;
	   if (i == 0) 
		   colName = "fileID";
	   else if (i == 1)
		   colName = "projID";
	   else if (i == 2)
		   colName = "format";
	   else if (i == 3)
		   colName = "fileName";
	   else if (i == 4)
		   colName = "location";
	   else 
		   throw new Exception("Access to invalid column number in courselist table");
	   
	   return colName;
   }
   
   // set data column i to value
   public void setColumnData(int i, Object value) throws Exception {
	   if (i == 0) 
		   fileID = (String) value;
	   else if (i == 1) 
		   projID = (String) value;
	   else if (i == 2) 
		   format =  (String) value;
	   else if (i == 3)
		   fileName = (String) value;
	   else if (i == 4)
		   location = (String) value;
	   else
		   throw new Exception("Error: invalid column index in courselist table");    
   }
   
  @Override
  public String toString() {
    return "Files [File ID =" + fileID + ", "
    		+ " Project ID =" + projID + ", "
    	    + " Format =" + format + ","
    	    + " File Name =" + fileName + ","
    	    + " Location =" + location + ","
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