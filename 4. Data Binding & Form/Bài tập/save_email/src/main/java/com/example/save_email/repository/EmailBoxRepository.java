package com.example.save_email.repository;

import com.example.save_email.model.EmailBox;
import org.springframework.stereotype.Repository;

@Repository
public class EmailBoxRepository implements IEmailBoxRepository {

    public static EmailBox emailBox;
    static {
        emailBox = new EmailBox("US", "5",true, "Thor, king, Asgard");
    }

    @Override
    public EmailBox getEmailBox() {
        return emailBox;
    }

    @Override
    public void updateEmailBox(EmailBox emailBox) {
        emailBox.setLanguage(emailBox.getLanguage());
        emailBox.setPageSize(emailBox.getPageSize());
        emailBox.setSpamsFilter(emailBox.getSpamsFilter());
        emailBox.setSignature(emailBox.getSignature());
    }
}
