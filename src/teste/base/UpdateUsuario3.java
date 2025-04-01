package teste.base;

import modelo.base.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateUsuario3 {

    public static void main(String[] args) {
        EntityManagerFactory fbc = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = fbc.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 2L);
        usuario.setNome("Amanda Perez");

        em.detach(usuario); // Não vai sincronizar os dados, somente fazendo um merge
        em.merge(usuario); // Torna o dado gerenciado e sincroniza com o banco

        em.getTransaction().commit();

        em.close();
        fbc.close();
    }
}
