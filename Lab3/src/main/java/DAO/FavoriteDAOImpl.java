package DAO;
import java.util.List;
import Entity.Favorite;
import Utils.XJPA;
import jakarta.persistence.EntityManager;

public class FavoriteDAOImpl implements BaseDAO<Entity.Favorite, Long> {
    EntityManager em = XJPA.getEntityManager();

    public List<Favorite> findAll() {
        return em.createQuery("SELECT f FROM Favorite f", Favorite.class).getResultList();
    }

    public Favorite findById(Long id) {
        return em.find(Favorite.class, id);
    }

    public void create(Favorite favorite) {
        em.getTransaction().begin();
        em.persist(favorite);
        em.getTransaction().commit();
    }

    public void update(Favorite favorite) {
        em.getTransaction().begin();
        em.merge(favorite);
        em.getTransaction().commit();
    }

    public void deleteById(Long id) {
        em.getTransaction().begin();
        Favorite favorite = em.find(Favorite.class, id);
        if (favorite != null) em.remove(favorite);
        em.getTransaction().commit();
    }
}
