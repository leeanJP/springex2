package org.zerock.springex2.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex2.dto.TodoDTO;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello() {
        log.info("hello....");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1....");
        log.info("name ::: "+name);
        log.info("age ::: "+age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name="name",defaultValue = "AAA") String name,
                    @RequestParam(name="age" , defaultValue = "20") int age) {
        log.info("ex2....");
        log.info("name ::: "+name);
        log.info("age ::: "+age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3....");
        log.info("dueDate ::: "+dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model){
        log.info("ex4....");
        model.addAttribute("msg" , "message~!~!~!~!");

    }

    @GetMapping("/ex4_1")
    public void ex4_1(TodoDTO dto, Model model){
        log.info(dto);

        // 화면에서 ${dto}
    }


    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes){

        //쿼리스트링에 추가
        redirectAttributes.addAttribute("name", "ABC");
        //URL에서는 보이지 않고 JSP에서 일회용으로 사용할 수 있음
        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6(){

    }


    @GetMapping("/ex7")
    public void ex7(String p1, int p2){
        log.info("ex7....");
        log.info("p1 ::: "+p1);
        log.info("p2 ::: "+p2);
    }

}
