package DAO;
import java.util.List;
import Entity.User;
import Utils.XJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class UserDAOImpl implements BaseDAO<User, Long> {
	EntityManager em = XJPA.getEntityManager();

	public List<User> findAll() {
		return em.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	public User findById(Long id) {
		return em.find(User.class, id);
	}


	public void create(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	public void update(User user) {
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
	}

	public void deleteById(Long id) {
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		if (user != null)
			em.remove(user);
		em.getTransaction().commit();
	}
	
//	bai1
	public User findByIdOrEmail(String idOrEmail) {
	    try {
	        try {
	            Long id = Long.parseLong(idOrEmail);
	            return em.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
	                     .setParameter("id", id)
	                     .getSingleResult();
	        } catch (NumberFormatException e) {
	            return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
	                     .setParameter("email", idOrEmail)
	                     .getSingleResult();
	        }
	    } catch (NoResultException ex) {
	        return null;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return null;
	    }
	}

}