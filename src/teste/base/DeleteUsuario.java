package teste.base;

import modelo.base.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteUsuario {

    public static void main(String[] args) {
        EntityManagerFactory fbc = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = fbc.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 10L);

        if(usuario != null){
            em.getTransaction().begin();

            em.remove(usuario);

            em.getTransaction().commit();
        } else {
            System.out.println("Usuário não encontrado!!!");
        }

        em.close();
        fbc.close();
    }
}
