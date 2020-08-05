package com.chatbot.web.passenger;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id") private Long passengerId;
    @Column(name = "passenger_number", nullable = false) private int passengerNumber;
    @Column(name = "survived", nullable = false) private int survived;
    @Column(name = "pclass") private int pclass;
    @Column(name = "name") private String name;
    @Column(name = "sex") private String sex;
    @Column(name = "age") private int age;
    @Column(name = "sib_sp") private int sib_sp;
    @Column(name = "parch") private int parch;
    @Column(name = "ticket") private String ticket;
    @Column(name = "fare") private String fare;
    @Column(name = "cabin") private String cabin;
    @Column(name = "embarked") private String embarked;



    @Builder
    public Passenger(int passengerNumber,
                 int survived,
                 int pclass,
                 String name,
                 String sex,
                 int age,
                 int sib_sp,
                 int parch,
                 String ticket,
                 String fare,
                 String cabin,
                 String embarked) {
        this.passengerNumber = passengerNumber;
        this.survived = survived;
        this.pclass = pclass;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sib_sp = sib_sp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
    }


}
