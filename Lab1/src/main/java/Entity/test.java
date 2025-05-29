package Entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class test {
    public static void main(String[] args) {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("J4Lab1");
//        EntityManager em = factory.createEntityManager();
//        System.out.println("Kết nối thành công");
//        
		UserManager um = new UserManager();
//		um.findByRole();
		um.findById();
    }
}