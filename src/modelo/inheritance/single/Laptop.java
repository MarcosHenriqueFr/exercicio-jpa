package modelo.inheritance.single;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "laptops")
public class Laptop extends Product {

    private String brand;

    public Laptop(){}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
