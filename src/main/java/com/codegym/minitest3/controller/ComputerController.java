package com.codegym.minitest3.controller;

import com.codegym.minitest3.model.entity.Computer;
import com.codegym.minitest3.model.entity.Type;
import com.codegym.minitest3.service.computerservice.ComputerService;
import com.codegym.minitest3.service.typeservice.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/computer")
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    @Autowired
    private TypeService typeService;

    @GetMapping()
    public String findAllComputer(Model model) {
        model.addAttribute("computers", computerService.findAll());
        return "computer/index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("computer", new Computer());
        return "computer/create";
    }

    @ModelAttribute("types")
    public Iterable<Type> listType() {
        return typeService.findAll();
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("computer") Computer computer) {
        computerService.save(computer);
        return "redirect:/computer";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Optional<Computer> computer = computerService.findById(id);
        model.addAttribute("computer", computer.get());
        return "computer/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("computer") Computer computer) {
        computerService.save(computer);
        return "redirect:/computer";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        computerService.remove(id);
        return "redirect:/computer";
    }
}
