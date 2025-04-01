package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

// Posso criar uma interface marcadora
public class DAO<E> {

    private static EntityManagerFactory fbc; //Serve para todos os meus DAO
    private EntityManager em; //Serve unicamente para essa instancia de DAO
    private Class<E> classe;

    static { // Isso aqui pode gerar muitos erros
        try {
            fbc = Persistence.createEntityManagerFactory("exercicios-jpa");
        } catch (RuntimeException e) {
            // Usar um mecanismo de log -> log4j
            e.getStackTrace();
        }
    }

    public DAO(Class<E> classe){
        this.classe = classe;
        em = fbc.createEntityManager();
    }

    public DAO(){
        this(null);
    }

    // Separou as partes
    public DAO<E> abrirT() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharT(){
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade){
        em.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade){
        return this.abrirT().incluir(entidade).fecharT();
    }

    public List<E> obterTodos(){
        return this.obterTodos(10, 0); // Comportamento padrão
    }

    //Limit e Offset, do SQL, para fazer a paginação da minha consulta
    public List<E> obterTodos(int limit, int offset){
        if(classe == null){
            throw new UnsupportedOperationException("Classe Nula");
        }

        // Toda consulta precisa de apelido
        String jpql = "SELECT e FROM " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);

        query.setMaxResults(limit);
        query.setFirstResult(offset);

        return query.getResultList();
    }

    // Fica mais flexivel, porque posso fechar e abrir de novo
    public void fechar(){
        em.close();
    }
}
