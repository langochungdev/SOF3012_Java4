package dao;
import java.util.List;
import entity.Favorite;
import entity.User;
import utils.XJPA;
import jakarta.persistence.EntityManager;

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
	
	public User findByIdOrEmail(String idOrEmail) {
        try {
            Long id = null;
            try {
                id = Long.parseLong(idOrEmail); 
            } catch (NumberFormatException e) {
               
            }
            return em.createQuery("SELECT u FROM User u WHERE u.id = :id OR u.email = :email", User.class)
                     .setParameter("id", id)
                     .setParameter("email", idOrEmail)
                     .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}