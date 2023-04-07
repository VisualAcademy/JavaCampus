package com.hawaso.javacampus.models.buffets;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Broth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(max = 25)
    private String name;

    private boolean isVegan;

    @OneToMany(mappedBy = "broth")
    private List<Noodle> noodles = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }

    public List<Noodle> getNoodles() {
        return noodles;
    }

    public void setNoodles(List<Noodle> noodles) {
        this.noodles = noodles;
    }
}
