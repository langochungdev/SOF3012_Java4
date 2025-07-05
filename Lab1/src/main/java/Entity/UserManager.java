package entity;
import java.util.List;
import jakarta.persistence.*;

public class UserManager {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("j4lab1");
	EntityManager em = factory.createEntityManager();


	public void findAll() {
		String jpql = "SELECT o FROM User o";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		List<User> list = query.getResultList();
		
		list.forEach(user -> {
			String fullname = user.getFullname();
			boolean admin = user.getAdmin();
			String id =  user.getId();
			System.out.println(id + " " + fullname + " " + admin);
		});
	}
	
	
	public void findById(String id) { 
		User user = em.find(User.class, id);
		String fullname = user.getFullname();
		boolean admin = user.getAdmin();
		System.out.println(fullname + ": " + admin);
	}
	
	public void create() {
		User user = new User("U01", "123", "teo@gmail.com", "Tèo", false);
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	
	public void update() {
		User user = em.find(User.class, "user2");
		user.setFullname("Nguyễn Văn Tèo"); 
		user.setEmail("teonv@gmail.com");
		try {
			em.getTransaction().begin(); 
			em.merge(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteById() {
		User user = em.find(User.class, "user2");
		try {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public void findByRole() {
		String jpql = "SELECT o FROM User o WHERE o.email LIKE :email AND o.admin = :admin";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("email", "%@fpt.edu.vn");
		query.setParameter("admin", true);
		
		List<User> users = query.getResultList();
		if (users.size() > 0) {
			users.forEach(user -> {
				System.out.println("fullname: " + user.getFullname() + ", Email: " + user.getEmail());
			});
		} else {
			System.out.println("không có dữ liệu");
		}
	}
	
	public void findPage() {
		int pageNumber = 2; 
		int pageSize = 5;

		String jpql = "SELECT u FROM User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setFirstResult(pageNumber * pageSize); 
		query.setMaxResults(pageSize); 

		List<User> list = query.getResultList();
		if (list.isEmpty()) {
			System.out.println("Không có dữ liệu trang này");
		} else {
			list.forEach(user -> {
				System.out.println(user.getId() + " | " + user.getFullname() + " | " + user.getEmail() + " | admin: " + user.getAdmin());
			});
		}
	}

	
	
	  public static void main(String[] args) {
		UserManager um = new UserManager();
		um.findByRole();
//		um.findPage();
//		um.findAll();
//		um.findById("hung");
    }
}
