package com.example.demo.repository.entity;
import jakarta.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private boolean checked;

    @ManyToOne
    //@JoinColumn(name = "pastry_id")
    private Pastry pastry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Pastry getPastry() {
        return pastry;
    }

    public void setPastry(Pastry pastry) {
        this.pastry = pastry;

    }
}


