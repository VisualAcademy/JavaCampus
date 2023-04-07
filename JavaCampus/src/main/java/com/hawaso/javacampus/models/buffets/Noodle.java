package com.hawaso.javacampus.models.buffets;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

// 국수 모델 클래스
@Entity
public class Noodle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 25)
    private String name;

    @NotNull
    @Column(name = "broth_id")
    private Integer brothId;

    // 국수는 특정 육수에 속함
    @ManyToOne
    @JoinColumn(name = "broth_id", insertable = false, updatable = false)
    private Broth broth;

     // 한 국수에 여러 가지 소스가 포함될 수 있음
    @OneToMany(mappedBy = "noodle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Garnish> garnishes = new ArrayList<>();

    // Getters and Setters
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

    public Integer getBrothId() {
        return brothId;
    }

    public void setBrothId(Integer brothId) {
        this.brothId = brothId;
    }

    public Broth getBroth() {
        return broth;
    }

    public void setBroth(Broth broth) {
        this.broth = broth;
    }

    public List<Garnish> getGarnishes() {
        return garnishes;
    }

    public void setGarnishes(List<Garnish> garnishes) {
        this.garnishes = garnishes;
    }
}
