package com.hawaso.javacampus.models.buffets;

import javax.persistence.*;
import javax.validation.constraints.*;

// 고명(소스) 모델 클래스
@Entity
public class Garnish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 25)
    private String name;

    @Column(name = "noodle_id")
    private Integer noodleId;

    // 각 소스는 특정 국수에 속함
    @ManyToOne
    @JoinColumn(name = "noodle_id", insertable = false, updatable = false)
    private Noodle noodle;

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

    public Integer getNoodleId() {
        return noodleId;
    }

    public void setNoodleId(Integer noodleId) {
        this.noodleId = noodleId;
    }

    public Noodle getNoodle() {
        return noodle;
    }

    public void setNoodle(Noodle noodle) {
        this.noodle = noodle;
    }
}
