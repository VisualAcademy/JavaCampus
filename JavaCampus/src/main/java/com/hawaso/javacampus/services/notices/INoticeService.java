package com.hawaso.javacampus.services.notices;

import java.util.List;

import com.hawaso.javacampus.models.notices.Notice;

// INoticeService 인터페이스 설계 
public interface INoticeService {
    // 입력과 수정
    public void save(Notice model); // add(), update()
    // 출력
    public List<Notice> getAll(); // findAll()
    // 상세
    public Notice getById(int id); // findById()
    // 삭제
    public void delete(int id); // deleteById()
    // 검색
    public List<Notice> searchAll(String name, String title); // getByXXX()
}
