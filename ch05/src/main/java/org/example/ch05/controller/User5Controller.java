package org.example.ch05.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch05.dto.User4DTO;
import org.example.ch05.dto.User5DTO;
import org.example.ch05.service.User4Service;
import org.example.ch05.service.User5Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class User5Controller {

    // @RequiredArgsConstructor 어노테이션으로 의존객체 주입
    private final User5Service service;

    @GetMapping("/user5/list")
    public String list(Model model) {

        // 조회 서비스 요청
        List<User5DTO> dtoList = service.getAll();

        // 모델 참조 : 뷰(html)에서 컨트롤러 데이터 참조
        model.addAttribute("dtoList", dtoList);

        return "/user5/list";
    }

    @GetMapping("/user5/register")
    public String register() {

        return "/user5/register";
    }

    @PostMapping("/user5/register")
    public String register(User5DTO dto) {
        System.out.println(dto);

        // 등록 서비스 호출
        service.register(dto);

        return "redirect:/user5/list";
    }

    @GetMapping("/user5/modify")
    public String modify(String seq, Model model) {

        // 수정 조회 서비스 호출
        User5DTO dto = service.getById(seq);

        model.addAttribute(dto); // 키값 생략하면 해당 객체 소문자로 시작하는 타입명 ex) User2DTO

        return "/user5/modify";
    }

    @PostMapping("/user5/modify")
    public String modify(User5DTO dto) {

        // 수정 서비스 호출
        service.modify(dto);


        return "redirect:/user5/list?modify=success";
    }

    @GetMapping("/user5/remove")
    public String remove(String seq) {
        // 삭제 서비스 요청
        service.remove(seq);

        // 삭제후 목록이동
        return "redirect:/user5/list?remove=success";
    }
}
