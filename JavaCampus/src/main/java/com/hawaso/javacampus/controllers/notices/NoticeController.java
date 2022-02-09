package com.hawaso.javacampus.controllers.notices;

import javax.validation.Valid;

import com.hawaso.javacampus.models.notices.Notice;
import com.hawaso.javacampus.services.notices.NoticeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // 저장: 데이터 입력과 수정 기능을 동시에 처리
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("dto") Notice model, BindingResult br) {
        if (br.hasErrors()) {
            // 유효성 검사들 통과하지 못하면 다시 입력 폼으로 이동
            return "views/notices/create";
        }
        else {
            // 유효성 검사 통과하면 데이터 저장 또는 수정
            _service.save(model); 

            // 리스트 페이지로 이동
            return "redirect:/notice";
        }
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

    // 수정 폼 출력: 기존 데이터 함께 로드 
    @GetMapping("/editform")
    public String editform(@RequestParam("id") int id, Model model) {
        var dto = _service.getById(id);
        model.addAttribute("dto", dto);
        return "views/notices/create";
    }

    // 삭제
    @GetMapping("/delete")
    public String delete() {
        return "views/notices/delete";
    }

    // 삭제 처리
    @GetMapping("/deleteprocess")
    public String deleteprocess(@RequestParam("id") int id) {
        _service.delete(id);
        return "redirect:/notice";
    }   
}
