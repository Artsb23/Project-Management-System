import javax.persistence.*;

import java.util.*;

public class PeopleService {
	 private EntityManager manager;
	 
	 public PeopleService(EntityManager manager) {
		 this.manager = manager;
	 }
	 
    // method to create a new record
     public People createPeople(String peopleID, String personName, String projectID, String role) {
    	People people = new People();
    	people.setProjectID(projectID);
    	people.setPersonID(peopleID);
    	people.setRole(role);
    	people.setName(personName);
    	
 	    manager.persist(people);
 	    return people;
     }
    
    // method to read a record
     public People readPeople(String peopleID) {
    	 People people = manager.find(People.class, peopleID);
    	 return people;   	 
     }

     // method to read all records
     public List<People> readAll() {
    	 TypedQuery<People> query = manager.createQuery("SELECT e FROM project_people e", People.class);
    	 List<People> result =  query.getResultList();

    	 return result;   	 
     }
     
    // method to update a record
     public People updatePeople(String peopleID, String personName, String projectID, String role) {
    	 People people = manager.find(People.class, peopleID);
    	 if (people != null) {
    		 people.setProjectID(projectID);
    	    	people.setPersonID(peopleID);
    	    	people.setRole(role);
    	    	people.setName(personName);
    	    	
    	 }
    	 return people;
     }

    // method to delete a record
    public void deletePeople(String peopleID) {
    	 People people = manager.find(People.class, peopleID);
    	 if (people != null) {
    		 manager.remove(people);
    	 }
    }
    
    
    public List<People> Search_people(String projectName, String peopleName, String role)
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
    	String query = "SELECT e from project_people e WHERE";
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
    	if(!peopleName.isEmpty())
    	{
    		clause = query.substring(query.lastIndexOf(" ")+1);
    		if(clause.equals("WHERE"))
    			query += " e.name = '" + peopleName + "'";
    		else 
    			query += " AND e.name = '" + peopleName + "'"; 
    	}
    	if(!role.isEmpty())
    	{
    		clause = query.substring(query.lastIndexOf(" ")+1);
    		if(clause.equals("WHERE"))
    			query += " e.role = '" + role + "'";
    		else
    			query += " AND e.role = '" + role + "'";
    	}
    	
    	
    	TypedQuery<People> qp = manager.createQuery(query, People.class);
		List<People> results = qp.getResultList();
		
		System.out.println(result);
		return results;
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    		List<People> results = null;
    		return results;
    	}

    }
    
}
