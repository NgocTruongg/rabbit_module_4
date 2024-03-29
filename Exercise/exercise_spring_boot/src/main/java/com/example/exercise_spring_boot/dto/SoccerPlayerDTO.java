package com.example.exercise_spring_boot.dto;

import com.example.exercise_spring_boot.model.FootballTeam;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;


public class SoccerPlayerDTO implements Validator {
    private Integer id;

    @NotBlank(message = "mã cầu thủ không được để trống!")
    private String code;

    @NotBlank(message = "Tên không được để trống!")
    @Pattern(regexp = "^[A-Za-z ]{5,100}$", message = "Tên phải từ 5-100 kí tự và không chứa kí tự đặc biệt!")
    private String name;

    @NotBlank(message = "Phải lựa chọn ngày sinh phù hợp !")
    private String dateOfBirth;

    @Pattern(regexp = "^[0-9]*[1-9][0-9]*$", message = "Kinh nghiệm phải là số nguyên dương!")
    private String experience;

    @Pattern(regexp = "(^(Trung vệ|Hậu vệ|Tiền vệ|Tiền đạo|Thủ môn)$)",
            message = "Vị trí phải là 1 trong 4 vị trí sau (Trung vệ,  Hậu vệ,Tiền vệ,Tiền đạo hoặc là Thủ môn)!")
    private String location;

    @NotNull
    @NotBlank(message = "Phải có ảnh của cầu thủ!")
    private String img;


    private FootballTeam footballTeam;

    public SoccerPlayerDTO() {
    }

    public SoccerPlayerDTO(Integer id, String code, String name, String dateOfBirth, String experience,
                           String location, String img, FootballTeam footballTeam) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.location = location;
        this.img = img;
        this.footballTeam = footballTeam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public FootballTeam getFootballTeam() {
        return footballTeam;
    }

    public void setFootballTeam(FootballTeam footballTeam) {
        this.footballTeam = footballTeam;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SoccerPlayerDTO soccerPlayerDTO = (SoccerPlayerDTO) target;
        if (!soccerPlayerDTO.dateOfBirth.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
            Period age = Period.between(LocalDate.parse(soccerPlayerDTO.getDateOfBirth()), LocalDate.now());
            int years = age.getYears();
            if (16 > years || years > 100) {
                errors.rejectValue("dateOfBirth", "", "Tuổi phải từ 16 đến 100!");
            }
        }
    }
}
