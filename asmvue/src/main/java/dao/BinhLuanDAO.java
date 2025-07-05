package dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.BinhLuan;
import utils.XJPA;
import java.util.List;

public class BinhLuanDAO implements BaseDAO<BinhLuan, String> {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public BinhLuan findById(String id) {
        return em.find(BinhLuan.class, id);
    }
    
    public List<BinhLuan> findByBaiVietId(String baiVietId) {
        TypedQuery<BinhLuan> query = em.createQuery(
            "SELECT b FROM BinhLuan b WHERE b.baiViet.maBaiViet = :id", BinhLuan.class
        );
        query.setParameter("id", baiVietId);
        return query.getResultList();
    }


    @Override
    public List<BinhLuan> findAll() {
        TypedQuery<BinhLuan> query = em.createQuery("SELECT b FROM BinhLuan b", BinhLuan.class);
        return query.getResultList();
    }
    @Override
    public void create(BinhLuan bl) {
        try {
            if (!em.getTransaction().isActive())
                em.getTransaction().begin();

            if (bl.getMaBinhLuan() == null || bl.getMaBinhLuan().isEmpty()) {
                bl.setMaBinhLuan("BL" + System.currentTimeMillis());
            }

            em.persist(bl);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;
        }
    }


    @Override
    public void update(BinhLuan bl) {
        try {
            if (!em.getTransaction().isActive())
                em.getTransaction().begin();
            em.merge(bl);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteById(String id) {
        try {
            BinhLuan bl = findById(id);
            if (bl != null) {
                if (!em.getTransaction().isActive())
                    em.getTransaction().begin();
                em.remove(bl);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;
        }
    }


}
