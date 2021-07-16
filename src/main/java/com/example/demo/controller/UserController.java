package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/add")
    public String getAddPage(){
        return "addUser";
    }
    @PostMapping("users/add")
    public String addUser(@RequestParam String name, @RequestParam String description,
    @RequestParam Long sum){
        User user = new User(null,name,description,sum);
        userRepository.save(user);
        return "redirect:/user";
    }

    @GetMapping("/users/{name}")
    public String userinfo(@PathVariable String name, Model model){
        List<User> users= userRepository.findByName(name);
        model.addAttribute("users",users);
        return "UserInfo";
    }
    @GetMapping("/users/update/{id}")
    public String editInfo(@PathVariable Long id,Model model){
        model.addAttribute("user",userRepository.findById(id));
        return "addUser";
    }
    @PostMapping("/users/update/{id}")
    public String editInfobyid(@PathVariable Long id,@RequestParam String name,
                               @RequestParam String description, @RequestParam Long sum){
        User user = userRepository.findById(id).orElseThrow();
        user.setName(name);
        user.setDescription(description);
        user.setSum(sum);
        userRepository.save(user);
        return "redirect:/users/"+name;

    }
    @GetMapping("/users/delete/{id}")
    public String deletebyid(@PathVariable Long id){
        User user = userRepository.findById(id).orElseThrow();
        String name = user.getName();
        userRepository.deleteById(id);
        return "redirect:/users/"+name;

    }


}
