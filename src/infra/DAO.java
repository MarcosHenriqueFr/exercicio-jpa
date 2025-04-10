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

    public E obterPorId(Object id){
        return em.find(classe, id);
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


    // Sempre que for fazer consultas, faça paginações
    public List<E> consultar(String nomeConsulta, Object... params){
        TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);

        // Já que os meus parametros vão ir de dois em dois, as informações de chave vão ser add
        for(int i = 0; i < params.length; i += 2){
            query.setParameter(params[i].toString(), params[i+1]);
        }

        return query.getResultList();
    }

    // Consulta somente um por causa da função agregadora do SQL(AVG())
    public E consultarUm(String nomeConsulta, Object... params){
        List<E> lista = consultar(nomeConsulta, params);
        return lista.isEmpty() ? null : lista.getFirst();
    }

    // Fica mais flexivel, porque posso fechar e abrir de novo
    public void fechar(){
        em.close();
    }
}
