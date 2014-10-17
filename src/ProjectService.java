import javax.persistence.*;

import java.util.*;

public class ProjectService {
	private EntityManager manager;

	public ProjectService(EntityManager manager) {
		this.manager = manager;
	}

	// method to create a new record
	public Project createProject(String projectID, String projectName,
			String startDate, String endDate, String scope, String status,
			String category, String outcome, String lastUpdated,
			String updatedBy) {
		Project prj = new Project();
		prj.setProjectName(projectName);
		prj.setProjectID(projectID);
		prj.setFromDate(startDate);
		prj.setToDate(endDate);
		prj.setScope(scope);
		prj.setStatus(status);
		prj.setCategory(category);
		prj.setOutcome(outcome);
		prj.setLastUpdated(lastUpdated);
		prj.setUpdatedBy(scope);
		manager.persist(prj);
		return prj;
	}

	// method to read a record
	public Project readProject(String projID) {
		Project prj = manager.find(Project.class, projID);
		return prj;
	}

	// method to read all records
	public List<Project> readAll() {
		TypedQuery<Project> query = manager.createQuery(
				"SELECT e FROM project e", Project.class);
		List<Project> result = query.getResultList();

		return result;
	}

	// method to update a record
	public Project updateProject(String projectName, String projectID,
			String startDate, String endDate, String scope, String status,
			String category, String outcome, String lastUpdated,
			String updatedBy) {
		Project prj = manager.find(Project.class, projectID);
		if (prj != null) {
			prj.setProjectName(projectName);
			prj.setProjectID(projectID);
			prj.setFromDate(startDate);
			prj.setToDate(endDate);
			prj.setScope(scope);
			prj.setStatus(status);
			prj.setCategory(category);
			prj.setOutcome(outcome);
			prj.setLastUpdated(lastUpdated);
			prj.setUpdatedBy(scope);
		}
		return prj;
	}

	// method to delete a record
	public void deleteProject(String projectID) {
		Project prj = manager.find(Project.class, projectID);
		if (prj != null) {
			manager.remove(prj);
		}
	}

	public List<String> getCategoryComboBoxesData() {
		String query = "SELECT distinct e.category from project e";
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		TypedQuery<String> q = manager.createQuery(query, String.class);

		List<String> result = q.getResultList();
		return result;
	}

	public List<String> getStatusComboBoxesData() {
		String query = "SELECT distinct e.status from project e";
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		TypedQuery<String> q = manager.createQuery(query, String.class);

		List<String> result = q.getResultList();
		return result;
	}

	public List<String> getScopeComboBoxesData() {
		String query = "SELECT distinct e.scope from project e";
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		TypedQuery<String> q = manager.createQuery(query, String.class);

		List<String> result = q.getResultList();
		return result;
	}

	public List<Project> Search(String projectName, String startDate,
			String endDate, String scope, String status, String category,
			String outcome, String lastUpdated, String updatedBy) {
		String query = "SELECT e from project e WHERE";
		String clause = query.substring(query.lastIndexOf(" ") + 1);
		try {
			if (!projectName.isEmpty()) {
				if (clause.equals("WHERE")) {
					query += " e.projName = '" + projectName + "'";
				} else
					query += " AND e.projName = '" + projectName + "'";
			}
			if (!startDate.isEmpty()) {
				clause = query.substring(query.lastIndexOf(" ") + 1);
				if (clause.equals("WHERE"))
					query += " e.fromDate = '" + startDate + "'";
				else
					query += " AND e.fromDate = '" + startDate + "'";
			}
			if (!endDate.isEmpty()) {
				clause = query.substring(query.lastIndexOf(" ") + 1);
				if (clause.equals("WHERE"))
					query += " e.toDate = '" + endDate + "'";
				else
					query += " AND e.toDate = '" + endDate + "'";
			}
			if (!scope.isEmpty()) {
				clause = query.substring(query.lastIndexOf(" ") + 1);
				if (clause.equals("WHERE"))
					query += " e.scope = '" + scope + "'";
				else
					query += " AND e.scope = '" + scope + "'";
			}
			if (!status.isEmpty()) {
				clause = query.substring(query.lastIndexOf(" ") + 1);
				if (clause.equals("WHERE"))
					query += " e.status = '" + status + "'";
				else
					query += " AND e.status = '" + status + "'";
			}
			if (!category.isEmpty()) {
				clause = query.substring(query.lastIndexOf(" ") + 1);
				if (clause.equals("WHERE"))
					query += " e.category = '" + category + "'";
				else
					query += " AND e.category = '" + category + "'";
			}
			if (!outcome.isEmpty()) {
				clause = query.substring(query.lastIndexOf(" ") + 1);
				if (clause.equals("WHERE"))
					query += " e.outcome = '" + outcome + "'";
				else
					query += " AND e.outcome = '" + outcome + "'";
			}
			if (!lastUpdated.isEmpty()) {
				if (clause.equals("WHERE"))
					query += " e.lastUpdated = '" + lastUpdated + "'";
				else
					query += " AND e.lastUpdated = '" + lastUpdated + "'";
			}
			if (!updatedBy.isEmpty()) {
				clause = query.substring(query.lastIndexOf(" ") + 1);
				if (clause.equals("WHERE"))
					query += " e.updatedBy = '" + updatedBy + "'";
				else
					query += " AND e.updatedBy = '" + updatedBy + "'";
			}
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("PersistenceUnit");
			EntityManager manager = emf.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			TypedQuery<Project> q = manager.createQuery(query, Project.class);

			List<Project> result = q.getResultList();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			List<Project> result = null;
			return result;
		}

	}

	public List<Project> Search_file(String projectName, String fileName,
			String format) {
		String query1 = "SELECT distinct e.projID from project e WHERE e.projName='"
				+ projectName + "'";
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		TypedQuery<Object> q = manager.createQuery(query1, Object.class);
		List<Object> result = q.getResultList();
		String projectID = "";
		for (Object data : result) {
			projectID = (String) data;
		}
		System.out.println(projectID);
		String query = "SELECT e from project_files e WHERE";
		String clause = query.substring(query.lastIndexOf(" ") + 1);
		try {
			if (!projectID.isEmpty()) {
				if (clause.equals("WHERE")) {
					query += " e.projID = '" + projectID + "'";
				} else
					query += " AND e.projID = '" + projectID + "'";
			}
			if (!fileName.isEmpty()) {
				clause = query.substring(query.lastIndexOf(" ") + 1);
				if (clause.equals("WHERE"))
					query += " e.fileName = '" + fileName + "'";
				else
					query += " AND e.fileName = '" + fileName + "'";
			}
			if (!format.isEmpty()) {
				clause = query.substring(query.lastIndexOf(" ") + 1);
				if (clause.equals("WHERE"))
					query += " e.format = '" + format + "'";
				else
					query += " AND e.format = '" + format + "'";
			}

			TypedQuery<Project> qp = manager.createQuery(query, Project.class);
			List<Project> results = qp.getResultList();

			System.out.println(result);
			return results;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			List<Project> results = null;
			return results;
		}

	}

}
