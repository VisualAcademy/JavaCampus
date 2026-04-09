package com.hawaso.javacampus.components;

import com.hawaso.javacampus.services.notices.NoticeService;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NoticeListener implements ApplicationListener<ApplicationReadyEvent> {
    private final NoticeService _service; 

    public NoticeListener(NoticeService service) {
        this._service = service; 
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("==========Notices 테이블 데이터 테스트 출력==========");
        var notices = this._service.getAll(); 
        notices.forEach(System.out::println);
    }    
}
