package com.apress.spring.springbootjournal;

import com.apress.spring.springbootjournal.domain.Journal;
import com.apress.spring.springbootjournal.repository.JournalRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = ActiveMQAutoConfiguration.class)
public class SpringBootJournalApplication implements CommandLineRunner {

    @Autowired
    private CommandLine commandLine;


    @Override
    public void run(String... args) throws Exception {
        commandLine.runCommandline(args);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class, args);

    }





    @Bean
    InitializingBean saveData(JournalRepository journalRepository){
        return () -> {
            journalRepository.save(new Journal("Get to know Spring Boot","Today I will learn Spring Boot","01/01/2016"));
            journalRepository.save(new Journal("Simple Spring Boot Project","I will do my first Spring Boot Project","01/02/2016"));
            journalRepository.save(new Journal("Spring Boot Reading","Read more about Spring Boot","02/01/2016"));
            journalRepository.save(new Journal("Spring Boot in the Cloud","Spring Boot using Cloud Foundry","03/01/2016"));
        };
    }
}
