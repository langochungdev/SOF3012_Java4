package Controller;
import Utils.XJPA;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import Entity.Visitor;

@WebListener
public class b2 implements ServletContextListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManager em = XJPA.getEntityManager();
        int visitors = 0;

        try {
            Visitor v = em.find(Visitor.class, 1);
            if (v != null) {
                visitors = v.getCount();
            }
        } finally {
            em.close();
        }

        sce.getServletContext().setAttribute("visitors", visitors);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        Integer visitors = (Integer) context.getAttribute("visitors");
        if (visitors == null) visitors = 0;

        EntityManager em = XJPA.getEntityManager();
        try {
            em.getTransaction().begin();
            Visitor v = em.find(Visitor.class, 1);
            if (v == null) {
                v = new Visitor();
                v.setId(1);
            }
            v.setCount(visitors);
            em.persist(v);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();

        synchronized (context) {
            Integer visitors = (Integer) context.getAttribute("visitors");
            if (visitors == null) visitors = 0;
            visitors++;
            context.setAttribute("visitors", visitors);
        }
    }

    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
