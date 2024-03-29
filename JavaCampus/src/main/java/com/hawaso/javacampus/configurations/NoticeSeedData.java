package com.hawaso.javacampus.configurations;

import com.hawaso.javacampus.models.notices.Notice;
import com.hawaso.javacampus.services.notices.NoticeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NoticeSeedData {
    private static final Logger _log = LoggerFactory.getLogger(NoticeSeedData.class);

    @Bean
    public CommandLineRunner initNotices(NoticeService service) {
        return args -> {
            _log.info("Preloading: " + service.save(new Notice("홍길동", "제목1", "내용1")));
            _log.info("Preloading: " + service.save(new Notice("백두산", "제목2", "내용2")));
            _log.info("Preloading: " + service.save(new Notice("임꺽정", "제목3", "내용3")));
            _log.info("Preloading: " + service.save(new Notice("홍길동", "제목1", "내용4")));
            _log.info("Preloading: " + service.save(new Notice("백두산", "제목2", "내용5")));
            _log.info("Preloading: " + service.save(new Notice("임꺽정", "제목3", "내용6")));
            _log.info("Preloading: " + service.save(new Notice("홍길동", "제목1", "내용7")));
            _log.info("Preloading: " + service.save(new Notice("백두산", "제목2", "내용8")));
            _log.info("Preloading: " + service.save(new Notice("임꺽정", "제목3", "내용9")));
            _log.info("Preloading: " + service.save(new Notice("홍길동", "제목1", "내용10")));
            _log.info("Preloading: " + service.save(new Notice("백두산", "제목2", "내용11")));
            _log.info("Preloading: " + service.save(new Notice("임꺽정", "제목3", "내용12")));
            _log.info("Preloading: " + service.save(new Notice("홍길동", "제목1", "내용13")));
            _log.info("Preloading: " + service.save(new Notice("백두산", "제목2", "내용14")));
            _log.info("Preloading: " + service.save(new Notice("임꺽정", "제목3", "내용15")));
        };
    }
}
