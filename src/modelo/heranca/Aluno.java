package modelo.heranca;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

// Pode ser single table, table por classe ou joined
// UMA_POR_CLASSE -> não estão relacionadas
// SINGLE TABLE -> Cria só uma tabela de acordo com a classe pai -> tem que possuir um discriminatorColumn e value
// Basicamente uma coluna de tipo, melhor dependendo da necessidade do sistema
// JOINED -> Tabela pai - Valores comuns de todos os filhos, Tabela filho -> recebe uma fk pelo id

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Tres estratégias
public class Aluno {

    @Id
    private Long matricula;
    private String nome;

    public Aluno() {

    }

    public Aluno(Long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
