package com.example.demo.controllers;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Contact/")
public class ContactController {
    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @GetMapping("getAll")
    public  ResponseEntity<List<Contact>> getAll() {

        return new ResponseEntity<List<Contact>>(this.contactRepository.findAll(),HttpStatus.OK);
    }

   
    @GetMapping("getOne/{id}")
    public ResponseEntity<Optional<Contact>> getOne(@PathVariable long id) {
        return new ResponseEntity<Optional<Contact>>(this.contactRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping("/createContact")
    public void newContact(@RequestBody Contact contact) {
        this.contactRepository.save(contact);
    }

    @PutMapping("/updateContact/{id}")
    public ResponseEntity<Contact> updateTutorial(@PathVariable("id") long id, @RequestBody Contact contact) {
        Optional<Contact> contactData = contactRepository.findById(id);
        if (contactData.isPresent()) {
            Contact _contact = contactData.get();
            _contact.setEmail(contact.getEmail());
            _contact.setFirstName(contact.getFirstName());
            _contact.setLastName(contact.getLastName());
            return new ResponseEntity<>(contactRepository.save(_contact), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteContact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable("id") long id) {
        try {
            contactRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
