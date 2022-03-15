package com.hawaso.javacampus.services.notices;

import java.util.List;

import com.hawaso.javacampus.models.notices.Notice;

// INoticeService 인터페이스 설계 
public interface INoticeService {
    // 입력과 수정
    public Notice save(Notice model); // add(), update()
    // 입력 
    public void add(Notice model); 
    // 출력
    public List<Notice> getAll(); // findAll()
    // 상세
    public Notice getById(int id); // findById()
    // 수정
    public void update(Integer id, Notice model);
    // 삭제
    public void delete(int id); // deleteById()
    // 검색
    public List<Notice> searchAll(String name, String title); // getByXXX()
}
