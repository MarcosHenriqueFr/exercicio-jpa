package modelo.inheritance.mappedsuper;

import javax.persistence.Entity;

@Entity
public class Employee extends Person {

    private String company;

    public Employee(){}

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
