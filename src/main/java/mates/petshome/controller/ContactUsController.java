package mates.petshome.controller;

import lombok.RequiredArgsConstructor;
import mates.petshome.model.ContactUsForm;
import mates.petshome.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact_us")
@RequiredArgsConstructor
public class ContactUsController {
    private final EmailService emailService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void contactUs(@RequestBody ContactUsForm form) {
        emailService.notifyAboutNewContactUsRequest(form);
    }
}
