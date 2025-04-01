package teste.base;

import modelo.base.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateUsuario1 {

    public static void main(String[] args) {
        EntityManagerFactory fbc = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = fbc.createEntityManager();

        // Alteração no meu banco de dados = transação no meu jpa

        em.getTransaction().begin();

        // Somente alterando os valores do meu objeto
        Usuario usuario = em.find(Usuario.class, 2L);
        usuario.setNome("Leandro");
        usuario.setEmail("Leandro@eee.com.br");

        em.merge(usuario); // Como se eu estivesse modificando uma branch

        em.getTransaction().commit();

        em.close();
        fbc.close();
    }
}
