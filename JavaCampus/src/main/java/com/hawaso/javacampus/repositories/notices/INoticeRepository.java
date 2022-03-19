package com.hawaso.javacampus.repositories.notices;

import java.util.List;

import com.hawaso.javacampus.models.notices.Notice;

// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 이미 CrudRepository를 상속하기에 생략해도 되지만, 명확하게 리포지토리 클래스를 표현하기 위해서
public interface INoticeRepository extends JpaRepository<Notice, Integer> {
    public List<Notice> findByOrderByIdDesc(); 
    public List<Notice> findByOrderByNameAsc(); 
    public List<Notice> findAllByOrderByTitleAsc(); 
    public List<Notice> findByNameContainsOrTitleContainingIgnoreCase(String name, String title);

    //public Page<Notice> findAllByOrderByIdDesc(Pageable pageable); // 페이징 처리 추가 
}
