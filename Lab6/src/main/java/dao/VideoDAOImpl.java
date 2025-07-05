package dao;
import java.util.List;
import entity.Video;
import utils.XJPA;
import jakarta.persistence.EntityManager;

public class VideoDAOImpl implements BaseDAO<Video, String> {
    EntityManager em = XJPA.getEntityManager();

    public List<Video> findAll() {
        return em.createQuery("SELECT v FROM Video v", Video.class).getResultList();
    }

    public Video findById(String id) {
        return em.find(Video.class, id);
    }

    public void create(Video video) {
        em.getTransaction().begin();
        em.persist(video);
        em.getTransaction().commit();
    }

    public void update(Video video) {
        em.getTransaction().begin();
        em.merge(video);
        em.getTransaction().commit();
    }

    public void deleteById(String id) {
        em.getTransaction().begin();
        Video video = em.find(Video.class, id);
        if (video != null) em.remove(video);
        em.getTransaction().commit();
    }
    
 	public List<Video> findByKeyword(String keyword) {
 		return em.createQuery("SELECT v FROM Video v WHERE v.title LIKE :keyword", Video.class)
 				.setParameter("keyword", "%" + keyword + "%").getResultList();
 	}


 	public List<Video> findTop10MostFavorited() {
 		return em.createQuery("SELECT v FROM Video v LEFT JOIN v.favorites f GROUP BY v ORDER BY COUNT(f) DESC",
 				Video.class).setMaxResults(10).getResultList();
 	}


 	public List<Video> findNotFavorited() {
 		return em.createQuery("SELECT v FROM Video v WHERE v.favorites IS EMPTY", Video.class).getResultList();
 	}


 	public List<Video> findSharedIn2024() {
 		return em.createQuery(
 				"SELECT v FROM Video v JOIN v.favorites f WHERE YEAR(f.likeDate) = 2024 ORDER BY f.likeDate",
 				Video.class).getResultList();
 	}


 	public List<Object[]> getVideoShareSummary() {
 		return em.createQuery(
 				"SELECT v.title, COUNT(f) as shareCount, MIN(f.likeDate) as firstShare, MAX(f.likeDate) as lastShare FROM Video v LEFT JOIN v.favorites f GROUP BY v.title",
 				Object[].class).getResultList();
 	}
}