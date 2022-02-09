package com.hawaso.javacampus.controllers.notices;

import com.hawaso.javacampus.models.notices.Notice;
import com.hawaso.javacampus.services.notices.NoticeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeService _service;

    // 생성자의 매개 변수로 NoticeService 클래스 주입 
    public NoticeController(NoticeService service) {
        this._service = service;
    }

    // 출력: 리스트 페이지 출력 
    @GetMapping(value = { "", "/index", "/list" })
    public String index(Model model) {
        var models = _service.getAll(); 
        model.addAttribute("models", models); 
        return "views/notices/index";
    }

    // 입력: 입력 폼 출력 
    @GetMapping(value = "/create")
    public String create(Model model) {
        // 빈 모델 오브젝트를 뷰 페이지에 dto, model, notice 등의 이름으로 전달 
        model.addAttribute("dto", new Notice());
        return "views/notices/create";
    }

    // 상세
    @GetMapping("/details")
    public String details() {
        return "views/notices/details";
    }

    // 수정
    @GetMapping("/edit")
    public String edit() {
        return "views/notices/edit";
    }

    // 삭제
    @GetMapping("/delete")
    public String delete() {
        return "views/notices/delete";
    }
}
