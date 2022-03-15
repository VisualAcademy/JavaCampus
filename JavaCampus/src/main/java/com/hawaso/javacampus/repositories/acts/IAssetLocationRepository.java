package com.hawaso.javacampus.repositories.acts;

import java.util.List;

import com.hawaso.javacampus.models.acts.AssetLocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 이미 CrudRepository를 상속하기에 생략해도 되지만, 명확하게 리포지토리 클래스를 표현하기 위해서
public interface IAssetLocationRepository extends JpaRepository<AssetLocation, Long> {
    public List<AssetLocation> findByOrderByIdDesc(); 
    public List<AssetLocation> findByOrderByDescriptionAsc(); 
    public List<AssetLocation> findAllByOrderByDescriptionAsc(); 
    public List<AssetLocation> findByDescriptionContainingIgnoreCase(String description);
}
