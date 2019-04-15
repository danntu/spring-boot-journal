package com.apress.spring.springbootjournal.web;

import com.apress.spring.springbootjournal.domain.Journal;
import com.apress.spring.springbootjournal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JournalController {
    @Autowired
    JournalRepository journalRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("journal",this.journalRepository.findAll());
        return "index";
    }

    @GetMapping(value = "/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Journal> getJournal(){
        return this.journalRepository.findAll();
    }

}
