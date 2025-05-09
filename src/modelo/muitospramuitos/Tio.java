package modelo.muitospramuitos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

// A tabela intermediária já é decidida automaticamente pelo JPA/HIBERNATE
// Mapeamento somente em um ponto, já que não tem bidirecional em um SQL

@Entity
@Table(name = "tios")
public class Tio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Será a base para criação da intermediária, com tios_sobrinhos
    @ManyToMany
    private List<Sobrinho> sobrinhos = new ArrayList<>();

    public Tio(){}

    public Tio(String nome) {
        this.nome = nome;
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

    public List<Sobrinho> getSobrinhos() {
        return sobrinhos;
    }

    public void setSobrinhos(List<Sobrinho> sobrinhos) {
        this.sobrinhos = sobrinhos;
    }
}
