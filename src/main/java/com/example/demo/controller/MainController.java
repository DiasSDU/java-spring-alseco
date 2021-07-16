package com.example.demo.controller;

import com.example.demo.model.Main;
import com.example.demo.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MainRepository mainRepository;

    @GetMapping("/user")
    public String getMainPage(Model model){
        return "redirect:/user/page/1";
    }

    @GetMapping("/user/page/{page}")
    public String getMainPageid(Model model,@PathVariable int page,
            @RequestParam(required = false) String sorting){

        int pageSize = 10;
        int pageNo = page;
        if(pageNo<1){
            pageNo=1;
        }
        String sortField = "name";
        String sortDirection="asc";
        if(sorting!=null) {
            String[] s = sorting.split(" ");
            sortField=s[0];
            sortDirection=s[1];
        }
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        List<Main> users = mainRepository.getMainPage(pageable);
        model.addAttribute("pageall",page);
        model.addAttribute("pageprev",page-1);
        model.addAttribute("users",users);
        return "Main";
    }

}