package com.hawaso.javacampus.repositories.notices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hawaso.javacampus.models.notices.Notice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//@SpringBootTest
@DataJpaTest
public class NoticeRepositoryTests {
    @Autowired
    private INoticeRepository _repository; 

    @Test
    public void findAllTest() {
        //[1] 1개의 데이터 저장 테스트 
        assertEquals(0, _repository.findAll().size());
        
        Notice model = new Notice("name", "title", "content");
        _repository.saveAndFlush(model); 
        
        
        assertEquals(1, _repository.findAll().size());
    }
}
