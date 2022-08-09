package com.pm430.springbootmongodb;

import com.pm430.springbootmongodb.account.Account;
import com.pm430.springbootmongodb.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringBootMongodbApplication {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Account account = new Account();
            account.setEmail("open.js@gmail.com_by_repo");
            account.setUsername("pm430_by_repo");

//            mongoTemplate.insert(account);
            accountRepository.insert(account);

            System.out.println("finish");
//            System.out.println(account.getUsername());
//            System.out.println(account.getEmail());
        };
    }
}
