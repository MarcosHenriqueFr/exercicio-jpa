package modelo.base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Tem que aplicar o ORM -> Usando annotations
//T0DO atributo está mapeado para ser uma coluna, assumindo valores padrões
//Um maior nivel de abstração

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Incremento, garante que cada um possua uma sequencia de id
	private Long id;
	private String nome;
	private String email;
	
	public Usuario() {
		
	}

	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
