package utils;
import jakarta.persistence.*;

public class XJPA {
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("j4lab3");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
