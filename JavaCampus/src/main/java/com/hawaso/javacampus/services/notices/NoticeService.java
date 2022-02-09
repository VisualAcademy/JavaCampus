package com.hawaso.javacampus.services.notices;

import java.util.List;

import com.hawaso.javacampus.models.notices.Notice;
import com.hawaso.javacampus.repositories.notices.INoticeRepository;

import org.springframework.stereotype.Service;

@Service // 현재 클래스를 서비스 클래스로 등록 => 컨트롤러 클래스에서 바로 주입 사용 가능 
public class NoticeService implements INoticeService {
    // @Autowired 생략
    private final INoticeRepository _repository;

    public NoticeService(INoticeRepository repository) {
        this._repository = repository;
    }

    // 입력과 수정 
    @Override
    public Notice save(Notice model) {
        return _repository.save(model);
    }

    // 입력
    public void add(Notice model) {
        _repository.save(model); 
    }

    // 출력
    @Override
    public List<Notice> getAll() {
        //List<Notice> notices = new ArrayList<>(); _repository.findAll().forEach(notices::add);
        return _repository.findByOrderByIdDesc(); 
    }

    // 상세
    @Override
    public Notice getById(int id) {
        var result = _repository.findById(id);

        if (result.isPresent()) {
            return result.get(); 
        }
        else {
            throw new RuntimeException("No Data."); // NoticeNotFoundException...
        }
    }

    // 수정
    public void update(Integer id, Notice model) {
        _repository.save(model); 
    }

    @Override
    public void delete(int id) {
        _repository.deleteById(id);        
    }

    @Override
    public List<Notice> searchAll(String name, String title) {
        return _repository.findByNameContainsOrTitleContainingIgnoreCase(name, title);
    }    
}
