package dao;
import java.util.List;
import entity.Log;
import utils.XJPA;
import jakarta.persistence.EntityManager;

public class LogDAOImpl implements BaseDAO<Log, Integer> {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public List<Log> findAll() {
        return em.createQuery("SELECT l FROM Log l", Log.class).getResultList();
    }

    @Override
    public Log findById(Integer id) {
        return em.find(Log.class, id);
    }

    @Override
    public void create(Log log) {
        em.getTransaction().begin();
        em.persist(log);
        em.getTransaction().commit();
    }

    @Override
    public void update(Log log) {
        em.getTransaction().begin();
        em.merge(log);
        em.getTransaction().commit();
    }

    @Override
    public void deleteById(Integer id) {
        em.getTransaction().begin();
        Log log = em.find(Log.class, id);
        if (log != null)
            em.remove(log);
        em.getTransaction().commit();
    }
}
