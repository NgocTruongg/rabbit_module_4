package com.example.save_email.service;

import com.example.save_email.model.EmailBox;

public interface IEmailBoxService {
    EmailBox getEmailBox();

    void updateEmailBox(EmailBox emailBox);
}
