package com.hawaso.javacampus.controllers.notices;

import javax.validation.Valid;

import com.hawaso.javacampus.models.notices.Notice;
import com.hawaso.javacampus.repositories.notices.INoticeRepository;
import com.hawaso.javacampus.services.notices.NoticeService;

import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    private INoticeRepository _repository;

    // 생성자의 매개 변수로 NoticeService 클래스 주입 
    public NoticeController(NoticeService service, INoticeRepository repository) {
        this._service = service;
        this._repository = repository;
    }

    // 출력: 리스트 페이지 출력 
    @GetMapping(value = { "", "/index", "/list" })
    public String index(Model model, @PageableDefault(page = 0, size = 2) Pageable pageable) {
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        Page<Notice> pages = 
            _repository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("id").descending()));
        //var models = _service.getAll(); 
        model.addAttribute("models", pages); 
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

    // 상세 페이지
    @GetMapping("/details")
    public String details(@RequestParam("id") int id, Model model) {
        var vm = _service.getById(id);
        model.addAttribute("vm", vm); 
        return "views/notices/details";
    }

    // 수정 페이지 
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

    // 삭제 페이지 
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

    // 검색 결과 리스트 출력
    @GetMapping("/search")
    public String search(@RequestParam("searchQuery") String searchQuery, Model model) {
        if (searchQuery.trim().isEmpty() && StringUtils.isEmpty(searchQuery)) {
            return "redirect:/notice";
        }
        else {
            var models = _service.searchAll(searchQuery, searchQuery);
            model.addAttribute("models", models);

            // 리스트 페이지에 검색 결과 컬렉션 표시 
            return "views/notices/index";
        }
    }
}
