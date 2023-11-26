package com.example.uploadtest;

public class MainModel {
    String  Title, Description, Skill, City, Experience,Extra,Salary, image;
     MainModel()
    {

    }
    public MainModel(String title, String description, String skill, String city, String experience, String extra, String salary, String image) {
        Title = title;
        Description = description;
        Skill = skill;
        City = city;
        Experience = experience;
        Extra = extra;
        Salary = salary;
        this.image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getSkill() {
        return Skill;
    }

    public void setSkill(String skill) {
        Skill = skill;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public String getExtra() {
        return Extra;
    }

    public void setExtra(String extra) {
        Extra = extra;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
