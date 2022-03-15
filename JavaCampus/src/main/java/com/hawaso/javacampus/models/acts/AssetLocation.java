package com.hawaso.javacampus.models.acts;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "AssetLocation")
public class AssetLocation {
    // 필드
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;
    @NotBlank(message = "Description을 입력하세요.")
    @Column(name = "Description")
    private String description;
    private Boolean isShow;
    private Boolean adjusted;

    // 생성자
    public AssetLocation() {
        // Empty
    }

    public AssetLocation(Long id, String description, Boolean isShow, Boolean adjusted) {
        this.id = id;
        this.description = description;
        this.isShow = isShow;
        this.adjusted = adjusted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getAdjusted() {
        return adjusted;
    }

    public void setAdjusted(Boolean adjusted) {
        this.adjusted = adjusted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AssetLocation))
            return false;
            AssetLocation model = (AssetLocation) o;
        return 
            Objects.equals(this.id, model.id) 
            && 
            Objects.equals(this.description, model.description)
            && 
            Objects.equals(this.isShow, model.isShow) 
            && 
            Objects.equals(this.adjusted, model.adjusted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.description, this.isShow, this.adjusted);
    }

    // ToString 메서드 오버라이드 
    @Override
    public String toString() {
        return "AssetLocation{" + "id=" + this.id + ", description='" 
        + this.description + '\'' + ", isShow='" + this.isShow
        + '\'' + ", adjusted='" + this.adjusted + '\'' + '}';
    }
}
