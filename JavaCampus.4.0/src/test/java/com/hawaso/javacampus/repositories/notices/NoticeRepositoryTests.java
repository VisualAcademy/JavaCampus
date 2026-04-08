package com.hawaso.javacampus.repositories.notices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hawaso.javacampus.models.notices.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

@DataJpaTest
class NoticeRepositoryTests {

    @Autowired
    private INoticeRepository repository;

    @Test
    void findAllTest() {
        assertEquals(0, repository.findAll().size());

        Notice model = new Notice("name", "title", "content");
        repository.saveAndFlush(model);

        assertEquals(1, repository.findAll().size());
    }
}
