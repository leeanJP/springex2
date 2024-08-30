package org.zerock.springex2.controller;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex2.dto.TodoDTO;
import org.zerock.springex2.service.TodoService;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/list")
    public void list(Model model){
        log.info("todo list........");

        model.addAttribute("dtoList", todoService.getAll());
    }

    //@RequestMapping(value = "/register" , method = RequestMethod.GET)
    @GetMapping("/register")
    public void registerGET(){
        log.info("GET todo register....");
    }

    @PostMapping("/register")
    public String registerPOST(@Valid TodoDTO todoDTO
    , BindingResult bindingResult
    , RedirectAttributes redirectAttributes){
        log.info("POST todo register....");

        if(bindingResult.hasErrors()){
            log.info("has errors..");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDTO);
        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }


    @GetMapping({"/read" ,"/modify"})
    public void read(Long tno, Model model){
        TodoDTO dto = todoService.getOne(tno);
        log.info("DTO ::: " + dto);
        model.addAttribute("dto", dto);

    }


    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        log.info("POST todo modify....");

        if(bindingResult.hasErrors()){
            log.info("has errors..");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }

        log.info(todoDTO);
        todoService.modify(todoDTO);

        return "redirect:/todo/list";


    }


    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes){

        log.info("REMOVE todo register....");
        log.info(tno);

        todoService.delete(tno);
        return "redirect:/todo/list";

    }




}
