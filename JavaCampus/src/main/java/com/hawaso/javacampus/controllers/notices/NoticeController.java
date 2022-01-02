package com.hawaso.javacampus.controllers.notices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    // 출력
    @GetMapping(value = { "", "/index" })
    public String index() {
        return "views/notices/index";
    }

    // 입력
    @GetMapping(value = "/create")
    public String create() {
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
