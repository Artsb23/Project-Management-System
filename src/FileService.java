
import javax.persistence.*;

import java.util.*;

public class FileService {
	 private EntityManager manager;
	 
	 public FileService(EntityManager manager) {
		 this.manager = manager;
	 }
	 
    // method to create a new record
     public Files createFile(String fileID, String projectID, String format, String fileName, String location) {
    	Files file = new Files();
    	file.setProjectID(projectID);
    	file.setFileID(fileID);
    	file.setFormat(format);
    	file.setFileName(fileName);
    	file.setLocation(location);
    	
 	    manager.persist(file);
 	    return file;
     }
    
    // method to read a record
     public Files readFiles(String fileID) {
    	 Files file = manager.find(Files.class, fileID);
    	 return file;   	 
     }

     // method to read all records
     public List<Files> readAll() {
    	 TypedQuery<Files> query = manager.createQuery("SELECT e FROM project_files e", Files.class);
    	 List<Files> result =  query.getResultList();

    	 return result;   	 
     }
     
    // method to update a record
     public Files updateFiles(String fileID, String projectID, String format, String fileName, String location) {
    	 Files file = manager.find(Files.class, fileID);
    	 if (file != null) {
    		 file.setProjectID(projectID);
    	    	file.setFileID(fileID);
    	    	file.setFormat(format);
    	    	file.setFileName(fileName);
    	    	file.setLocation(location);
    	 }
    	 return file;
     }

    // method to delete a record
    public void deleteFile(String fileID) {
    	 Files file = manager.find(Files.class, fileID);
    	 if (file != null) {
    		 manager.remove(file);
    	 }
    }
    
    
    public List<Files> Search_file(String projectName, String fileName, String format)
    {
    	String query1 = "SELECT distinct e.projID from project e WHERE e.projName='"+projectName+"'";
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		TypedQuery<Object> q = manager.createQuery(query1, Object.class);
		List<Object> result = q.getResultList();
		String projectID = "";
		for(Object data: result)
		{
			projectID = (String)data;
		}
		System.out.println(projectID);
    	String query = "SELECT e from project_files e WHERE";
    	String clause = query.substring(query.lastIndexOf(" ")+1);
    	try{
    	if(!projectID.isEmpty())
    	{
    		if(clause.equals("WHERE")){
    			query += " e.projID = '" + projectID + "'"; 
    			}
    		else
    			query += " AND e.projID = '" + projectID + "'";
    	}
    	if(!fileName.isEmpty())
    	{
    		clause = query.substring(query.lastIndexOf(" ")+1);
    		if(clause.equals("WHERE"))
    			query += " e.fileName = '" + fileName + "'";
    		else 
    			query += " AND e.fileName = '" + fileName + "'"; 
    	}
    	if(!format.isEmpty())
    	{
    		clause = query.substring(query.lastIndexOf(" ")+1);
    		if(clause.equals("WHERE"))
    			query += " e.format = '" + format + "'";
    		else
    			query += " AND e.format = '" + format + "'";
    	}
    	
    	
    	TypedQuery<Files> qp = manager.createQuery(query, Files.class);
		List<Files> results = qp.getResultList();
		
		System.out.println(result);
		return results;
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    		List<Files> results = null;
    		return results;
    	}

    }
    
}
