package modelo.muitospramuitos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double nota;

    // Para alterar configs padrões, já que o Hibernate faria automaticamente
    // Bom para bancos que ja existem
    // Define o nome da tabela, o nome da coluna do elemento atual, e o nome da coluna do outro elemento
    // Informações do próprio hibernate
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "atores_filmes",
            joinColumns = @JoinColumn(name = "filme_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ator_id",referencedColumnName = "id"))
    private List<Ator> atores = new ArrayList<>();

    public Filme(){}

    public Filme(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public List<Ator> getAtores() {
        // Sempre me retorne uma lista pelo menos vazia

        if(atores == null){
            atores = new ArrayList<>();
        }
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    // Criar um métoodo que facilite a adição de um elemento em nível de Orientação a objetos
    // Faz a adição dupla
    public void addAtor(Ator ator){
        // Validação para evitar que sejam adicionados mais valores

        if(ator != null && !atores.contains(ator)){
            atores.add(ator);

            if(!ator.getFilmes().contains(this)){
                ator.getFilmes().add(this);
            }
        }
    }
}
