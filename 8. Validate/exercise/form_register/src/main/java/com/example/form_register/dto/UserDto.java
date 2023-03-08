package com.example.form_register.dto;

import javax.validation.constraints.*;

public class UserDTO {

    @NotEmpty
    private Integer id;
    @NotBlank(message = "${firstName.notBlank}")
    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;

    @NotBlank(message = "${lastName.notBlank}")
    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;

    @NotBlank (message = "{phoneNumber.notBlank}")
    @Pattern(regexp = "(\\(\\d{3}\\)|\\d{3})[-\\. ]?\\d{3}[-\\. ]?\\d{4}")
    private String numberPhone;


    @NotBlank (message = "{age.notBlank}")
    @NotEmpty
    @Min(18)
    private String age;

    @NotBlank (message = "{email.notBlank}")
    @NotEmpty
    @Email
    private String email;

    public UserDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
