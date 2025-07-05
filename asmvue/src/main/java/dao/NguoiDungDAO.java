package dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.NguoiDung;
import utils.XJPA;

import java.util.List;

public class NguoiDungDAO implements BaseDAO<NguoiDung, String> {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public NguoiDung findById(String id) {
        try {
            String sql = "SELECT * FROM NguoiDung WHERE maNguoiDung COLLATE Latin1_General_CS_AS = :id";
            return (NguoiDung) em.createNativeQuery(sql, NguoiDung.class)
                .setParameter("id", id)
                .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }





    @Override
    public List<NguoiDung> findAll() {
        TypedQuery<NguoiDung> query = em.createQuery("SELECT n FROM NguoiDung n", NguoiDung.class);
        return query.getResultList();
    }

    @Override
    public void create(NguoiDung nd) {
        em.getTransaction().begin();
        em.persist(nd);
        em.getTransaction().commit();
    }

    @Override
    public void update(NguoiDung nd) {
        em.getTransaction().begin();
        em.merge(nd);
        em.getTransaction().commit();
    }

    @Override
    public void deleteById(String id) {
        NguoiDung nd = findById(id);
        if (nd != null) {
            em.getTransaction().begin();
            em.remove(nd);
            em.getTransaction().commit();
        }
    }
}
