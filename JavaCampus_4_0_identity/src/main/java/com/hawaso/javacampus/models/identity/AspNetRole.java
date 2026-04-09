package com.hawaso.javacampus.models.identity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AspNetRoles")
public class AspNetRole {

    @Id
    @Column(name = "Id", length = 64, nullable = false)
    private String id;

    @Column(name = "Name", length = 256)
    private String name;

    @Column(name = "NormalizedName", length = 256, unique = true)
    private String normalizedName;

    @Column(name = "ConcurrencyStamp", length = 256)
    private String concurrencyStamp;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getNormalizedName() { return normalizedName; }
    public void setNormalizedName(String normalizedName) { this.normalizedName = normalizedName; }
    public String getConcurrencyStamp() { return concurrencyStamp; }
    public void setConcurrencyStamp(String concurrencyStamp) { this.concurrencyStamp = concurrencyStamp; }
}
