package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Posso criar uma interface marcadora
public class DAO<E> {

    private static EntityManagerFactory fbc;
    private EntityManager em;

    static { // Isso aqui pode gerar muitos erros
        try {
            fbc = Persistence.createEntityManagerFactory("exercicios-jpa");
        } catch (RuntimeException e) {
            // Usar um mecanismo de log
            e.getStackTrace();
        }
    }

    public DAO(){
        em = fbc.createEntityManager();
    }
}
