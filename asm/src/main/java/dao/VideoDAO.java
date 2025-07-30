package dao;

import jakarta.persistence.*;
import model.Video;
import utils.XJPA;

import java.util.List;

public class VideoDAO implements BaseDAO<Video, String> {

	public List<Video> findAll() {
	    EntityManager em = XJPA.getEntityManager();
	    try {
	        String jpql = "SELECT v FROM Video v WHERE v.active = true";
	        return em.createQuery(jpql, Video.class).getResultList();
	    } finally {
	        em.close();
	    }
	}
	
	public List<Video> findAllEdit() {
	    EntityManager em = XJPA.getEntityManager();
	    try {
	        return em.createQuery("SELECT v FROM Video v", Video.class).getResultList();
	    } finally {
	        em.close();
	    }
	}


    @Override
    public Video findById(String id) {
        EntityManager em = XJPA.getEntityManager();
        return em.find(Video.class, id);
    }

    @Override
    public void create(Video entity) {
        EntityManager em = XJPA.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.clear();
    }

    @Override
    public void update(Video entity) {
        EntityManager em = XJPA.getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.clear();
    }

    @Override
    public void deleteById(String id) {
        EntityManager em = XJPA.getEntityManager();
        em.getTransaction().begin();
        Video entity = em.find(Video.class, id);
        if (entity != null) em.remove(entity);
        em.getTransaction().commit();
        em.clear();
    }
}
