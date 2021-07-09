package com.example.demo.controller;

import com.example.demo.model.todo;
import com.example.demo.repository.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class todoController {
    @Autowired
    private todoRepository todorepository;

    @GetMapping("/")
    public String todo(Model model){
        Iterable<todo> todos = todorepository.findAll();
        model.addAttribute("todos",todos);
        return "todolist";
    }
    @GetMapping("/todoadd")
    public String todoaddpage(Model model){
        return "index";
    }
    @GetMapping("/todoaddnew")
    public String todoaddnew(@RequestParam String fullname, @RequestParam Date date, @RequestParam int priority){
        todo todo = new todo(fullname,date,priority);
        todorepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/todolist/{id}")
    public String todolistdetails(@PathVariable(value="id") Long id,Model model){
        Optional<todo> todos = todorepository.findById(id);
        ArrayList<todo> todos1 = new ArrayList<>();
        todos.ifPresent(todos1::add);
        model.addAttribute(todos);
        return "index";
    }
    @GetMapping("/todolist/{id}/delete")
    public String tododelete(@PathVariable(value="id") Long id){
        todorepository.deleteById(id);
        return("redirect:/");
    }
    @PostMapping("/todoedit/{id}/edit")
    public String todoedit(@PathVariable(value="id") Long id,@RequestParam String fullname, @RequestParam Date date, @RequestParam int priority, @RequestParam boolean done){
        todo todo = todorepository.findById(id).orElseThrow();
        todo.setName(fullname);
        todo.setDate(date);
        todo.setPriority(priority);
        todo.setDone(done);
        todorepository.save(todo);
        System.out.println("dasfasfas");
        return "redirect:/";
    }
    @GetMapping("/todoedit/{id}/edit")
    public String todoedit(@PathVariable(value="id") Long id,Model model){
        Optional<todo> todos = todorepository.findById(id);
        ArrayList<todo> todos1 = new ArrayList<>();
        todos.ifPresent(todos1::add);
        model.addAttribute(todos);
        return "todo-edit";
    }

































}
