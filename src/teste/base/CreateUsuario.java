package teste.base;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.base.Usuario;

public class CreateUsuario {
	
	public static void main(String[] args) {
		
		// Parte que faz o crud, minha regra de negocio
		// Entity Manager -> Gerencia classes mapeadas -> CRUD

		// Passa a minha unidade de persistencia/Database
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("exercicios-jpa");

		// Encapsula a conexão com um único banco de dados
		EntityManager em = fabrica.createEntityManager();
		
		Usuario novoUsuario = new Usuario("Fernanda Castro", "fcastror@eemn.com.br");
		
		//Preciso ter uma transação, mapeamento feito pelo ORM
		em.getTransaction().begin();
		em.persist(novoUsuario); //Manda Insert
		em.getTransaction().commit();

		// Aqui ele tem id pq foi persistido, preocupação mais com os objetos
		System.out.println("O id gerado foi: " + novoUsuario.getId());
		
		em.close();
		fabrica.close();
	}
}
