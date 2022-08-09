package com.example.JPA.Model;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;


@Entity
@Table
public class PlayerModel {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName="student_sequence",
            allocationSize = 3
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int id;
    private String name;
    private String nationality;

    @Override
    public String toString() {
        return "PlayerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate=" + birthDate +
                ", titles=" + titles +
                ", age=" + age +
                '}';
    }

    private LocalDate birthDate;
    private int titles;

    @Transient
    private Integer age;

    public Integer getAge() {
        return Period.between(this.birthDate,LocalDate.now()).getYears();
    }


    public PlayerModel(String name, String nationality, LocalDate birthDate, int titles) {
        System.out.println("----------Player model constructor HIT-------------");

        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }

    public PlayerModel() {

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getTitles() {
        return titles;
    }


}
