package com.example.save_email.repository;

import com.example.save_email.model.EmailBox;

public interface IEmailBoxRepository {

    EmailBox getEmailBox();

    void updateEmailBox(EmailBox emailBox);
}
