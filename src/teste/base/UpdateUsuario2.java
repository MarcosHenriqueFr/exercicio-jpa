package teste.base;

import modelo.base.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateUsuario2 {
    public static void main(String[] args) {
        EntityManagerFactory fbc = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = fbc.createEntityManager();

        em.getTransaction().begin();

        // O contexto transacional

        Usuario usuario = em.find(Usuario.class, 2L);
        usuario.setNome("Jorge Amado");

        em.getTransaction().commit();

        em.close();
        fbc.close();
    }
}
