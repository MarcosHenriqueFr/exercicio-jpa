package teste.base;

import modelo.base.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class SelectReadUsuarios {

    public static void main(String[] args) {

        EntityManagerFactory fbc = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = fbc.createEntityManager();

        // Consultas no objeto em si, SELECT u.* FROM Usuario u -> apelido
        String jpql = "SELECT u FROM Usuario u";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class); //.class infos da classe, reflection
        query.setMaxResults(5);

        List<Usuario> usuarios = query.getResultList();

        for(Usuario u: usuarios){
            System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() + " | Email: " + u.getEmail());
        }

        em.close();
        fbc.close();
    }
}
