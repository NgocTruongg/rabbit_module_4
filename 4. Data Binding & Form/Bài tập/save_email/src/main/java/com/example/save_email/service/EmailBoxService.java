package com.example.save_email.service;

import com.example.save_email.model.EmailBox;
import com.example.save_email.repository.IEmailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailBoxService implements IEmailBoxService {

    @Autowired
    private IEmailBoxRepository emailRepository;


    @Override
    public EmailBox getEmailBox() {
        return emailRepository.getEmailBox();
    }

    @Override
    public void updateEmailBox(EmailBox emailBox) {
        emailRepository.updateEmailBox(emailBox);
    }
}
