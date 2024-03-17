package com.codegym.minitest3.controller;

import com.codegym.minitest3.model.entity.Type;
import com.codegym.minitest3.service.typeservice.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping()
    public String findAllComputer(Model model) {
        model.addAttribute("type", typeService.findAll());
        return "type/index";
    }
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("type", new Type());
        return "type/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("type") Type type) {
        typeService.save(type);
        return "redirect:/type";
    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Optional<Type> type = typeService.findById(id);
        model.addAttribute("type", type.get());
        return "type/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("type") Type type) {
        typeService.save(type);
        return "redirect:/type";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        typeService.remove(id);
        return "redirect:/type";
    }
}
