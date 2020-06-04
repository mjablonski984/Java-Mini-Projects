package com.example.SpringBootThymeleafForm.model;

import java.util.Date;

import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

public class User {

    @Size(min = 3, max = 50)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    @Size(min = 8, max = 15)
    private String password;

    @NotBlank(message = "Gender is required")
    private String gender;

    @AssertTrue(message = "You must accept terms")
    private boolean accept;

    @NotNull(message = "Birthday is required")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthday;

    @NotBlank
    private String profession;

    @Min(value = 20_000)
    @Max(value = 200_000)
    private long income;

    @Size(max = 100)
    private String note;

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    // override toString()
    @Override
    public String toString() {
        return "User [Name: " + name + " ,Email: " + email + " ,Gender: " + gender + " ,Note: " + note + " ,Accept: "
                + accept + ",Birthday: " + birthday + " ,Profession: " + profession + " ,Income: " + income;
    }

}