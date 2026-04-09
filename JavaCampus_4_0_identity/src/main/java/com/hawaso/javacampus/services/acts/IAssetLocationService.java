package com.hawaso.javacampus.services.acts;

import java.util.List;

import com.hawaso.javacampus.models.acts.AssetLocation;

// IAssetLocationService 인터페이스 설계 
public interface IAssetLocationService {
    // 입력과 수정
    public AssetLocation save(AssetLocation model); // add(), update()
    // 입력 
    public void add(AssetLocation model); 
    // 출력
    public List<AssetLocation> getAll(); // findAll()
    // 상세 
    public AssetLocation getById(long id); // findById()
    // 수정
    public void update(Integer id, AssetLocation model);
    // 삭제
    public void delete(long id); // deleteById()
    // 검색
    public List<AssetLocation> searchAll(String description); // getByXXX()
}
