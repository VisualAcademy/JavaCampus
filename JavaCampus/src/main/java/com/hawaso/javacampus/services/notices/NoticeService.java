package com.hawaso.javacampus.services.notices;

import java.util.List;

import com.hawaso.javacampus.models.notices.Notice;
import com.hawaso.javacampus.repositories.notices.INoticeRepository;

import org.springframework.stereotype.Service;

@Service // 현재 클래스를 서비스 클래스로 등록 => 컨트롤러 클래스에서 바로 주입 사용 가능 
public class NoticeService implements INoticeService {
    private final INoticeRepository _repository;

    public NoticeService(INoticeRepository repository) {
        this._repository = repository;
    }

    @Override
    public Notice save(Notice model) {
        return _repository.save(model);
    }

    @Override
    public List<Notice> getAll() {
        return _repository.findByOrderByIdDesc(); 
    }

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

    @Override
    public void delete(int id) {
        _repository.deleteById(id);        
    }

    @Override
    public List<Notice> searchAll(String name, String title) {
        return _repository.findByNameContainsOrTitleContainingIgnoreCase(name, title);
    }    
}
