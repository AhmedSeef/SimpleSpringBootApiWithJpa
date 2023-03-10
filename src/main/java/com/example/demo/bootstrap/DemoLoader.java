package com.example.demo.bootstrap;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoLoader implements CommandLineRunner {

    private final ContactRepository contactRepository;
    @Autowired
    public DemoLoader(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.contactRepository.save(new Contact("ahmed","gouda","ahmed.seef@gmail.com"));
    }
}
