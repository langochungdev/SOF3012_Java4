package Entity;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class UserManager {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("J4Lab1");
	EntityManager em = factory.createEntityManager();


	public void findAll() {
		String jpql = "SELECT o FROM Users o";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		List<User> list = query.getResultList();
		
		list.forEach(user -> {
			String fullname = user.getFullname();
			boolean admin = user.getAdmin();
			String id =  user.getId();
			System.out.println(id + " " + fullname + " " + admin);
		});
	}
	
	
	public void findById() { 
		User user = em.find(User.class, "user2");
		String fullname = user.getFullname();
		boolean admin = user.getAdmin();
		System.out.println(fullname + ": " + admin);
	}
	
	public void create() {
		User user = new User("U01", "123", "teo@gmail.com", "Tèo", false);
		try {
			em.getTransaction().begin();
			em.persist(user); // lưu đối tượng đợi commit để lưu 
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
		query.setParameter("email", "%@example.com");
		query.setParameter("admin", false);
		
		List<User> users = query.getResultList();
		if (users.size() > 0) {
			users.forEach(user -> {
				System.out.println("fullname: " + user.getFullname() + ", Email: " + user.getEmail());
			});
		} else {
			System.out.println("không có dữ liệu");
		}
	}
}
