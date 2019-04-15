package com.apress.spring.springbootjournal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandLine {

    @Bean
    String info(){
        return "Just a simple bean";
    }

    @Autowired
    String info;


    public void runCommandline(String... args) throws Exception {
        log.info("## > CommandLineRunner Implementation...");
        log.info("Accessing the Info bean: " + info);
        for(String arg:args)
            log.info(arg);
    }
}
