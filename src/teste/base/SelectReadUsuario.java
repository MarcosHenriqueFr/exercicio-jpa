package teste.base;

import modelo.base.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SelectReadUsuario { //Consultas

    public static void main(String[] args) {

        EntityManagerFactory fbc = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = fbc.createEntityManager();
        // Não preciso de transação(quando quero inserir)

        Usuario usuario = em.find(Usuario.class, 1L);
        System.out.println(usuario.getNome());

        em.close();
        fbc.close();
    }
}
