package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.BaiViet;
import utils.XJPA;

import java.util.List;

public class BaiVietDAO implements BaseDAO<BaiViet, String> {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public BaiViet findById(String id) {
        return em.find(BaiViet.class, id);
    }

    @Override
    public List<BaiViet> findAll() {
        TypedQuery<BaiViet> query = em.createQuery("SELECT b FROM BaiViet b", BaiViet.class);
        return query.getResultList();
    }

    @Override
    public void create(BaiViet bv) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        em.persist(bv);
        em.getTransaction().commit();
    }

    @Override
    public void update(BaiViet bv) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        em.merge(bv);
        em.getTransaction().commit();
    }

    @Override
    public void deleteById(String id) {
        BaiViet bv = findById(id);
        if (bv != null) {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.remove(bv);
            em.getTransaction().commit();
        }
    }

    public List<BaiViet> findByNguoiDung(String maNguoiDung) {
        EntityManager em = XJPA.getEntityManager();
        List<BaiViet> list = null;
        try {
            TypedQuery<BaiViet> query = em.createQuery(
                "SELECT b FROM BaiViet b WHERE b.nguoiDung.maNguoiDung = :maNguoiDung", BaiViet.class
            );
            query.setParameter("maNguoiDung", maNguoiDung);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }
}
