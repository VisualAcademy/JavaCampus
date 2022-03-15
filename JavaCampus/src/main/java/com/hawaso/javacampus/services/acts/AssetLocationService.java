package com.hawaso.javacampus.services.acts;

import java.util.List;

import com.hawaso.javacampus.models.acts.AssetLocation;
import com.hawaso.javacampus.repositories.acts.IAssetLocationRepository;

import org.springframework.stereotype.Service;

@Service // 현재 클래스를 서비스 클래스로 등록 => 컨트롤러 클래스에서 바로 주입 사용 가능 
public class AssetLocationService implements IAssetLocationService {
    // @Autowired 생략 가능: 생성자 주입 방식
    private final IAssetLocationRepository _repository;

    // 인터페이스 또는 클래스 리포지토리 주입
    public AssetLocationService(IAssetLocationRepository repository) {
        this._repository = repository;
    }

    // 입력과 수정 
    @Override
    public AssetLocation save(AssetLocation model) {
        return _repository.save(model);        
    }

    // 입력 
    @Override
    public void add(AssetLocation model) {
        _repository.save(model);         
    }    

    // 출력
    @Override
    public List<AssetLocation> getAll() {
        //List<AssetLocation> models = new ArrayList<>(); _repository.findAll().forEach(models::add);
        return _repository.findByOrderByIdDesc(); 
    }

    // 상세
    @Override
    public AssetLocation getById(long id) {
        var result = _repository.findById(id);

        if (result.isPresent()) {
            return result.get(); 
        }
        else {
            throw new RuntimeException("No Data."); // AssetLocationNotFoundException...
        }
    }

    // 수정
    @Override
    public void update(Integer id, AssetLocation model) {
        _repository.save(model);         
    }

    // 삭제 
    @Override
    public void delete(long id) {
        _repository.deleteById(id);
    }

    // 검색 
    @Override
    public List<AssetLocation> searchAll(String description) {
        return _repository.findByDescriptionContainingIgnoreCase(description);
    }
}
