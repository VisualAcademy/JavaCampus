package com.hawaso.javacampus.repositories.notices;

import java.util.List;

import com.hawaso.javacampus.models.notices.Notice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
    public List<Notice> findByOrderByIdDesc(); 
    public List<Notice> findByOrderByNameAsc(); 
    public List<Notice> findAllByOrderByTitleAsc(); 
    public List<Notice> findByNameContainsOrTitleContainingIgnoreCase(String name, String title);
}
