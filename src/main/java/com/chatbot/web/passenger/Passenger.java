package com.chatbot.web.passenger;

import lombok.*;

import javax.persistence.*;
/*
Variable Notes

0 PassengerId,1 Survived,2 Pclass,3 Name,4 Sex,
5 Age,6 SibSp,7 Parch,8 Ticket,9 Fare,
10 Cabin,11 Embarked

pclass: A proxy for socio-economic status (SES)
1st = Upper
2nd = Middle
3rd = Lower

age: Age is fractional if less than 1. If the age is estimated, is it in the form of xx.5

sibsp: The dataset defines family relations in this way...
Sibling = brother, sister, stepbrother, stepsister
Spouse = husband, wife (mistresses and fiancés were ignored)

parch: The dataset defines family relations in this way...
Parent = mother, father
Child = daughter, son, stepdaughter, stepson
Some children travelled only with a nanny, therefore parch=0 for them.
* */
@Entity
@Getter
@Setter
@ToString
@Table(name = "passenger")
@NamedQuery(name="Passenger.findByPclass",
query = "select e from Passenger e where e.pclass = :pclass")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id") private int passengerId;
    @Column(name = "survived", nullable = false) private int survived;
    @Column(name = "pclass") private int pclass;
    @Column(name = "name") private String name;
    @Column(name = "gender") private String gender;
    @Column(name = "age") private String age;
    @Column(name = "sib_sp") private String sibSp;
    @Column(name = "parch") private String parch;
    @Column(name = "ticket") private String ticket;
    @Column(name = "fare") private String fare;
    @Column(name = "cabin") private String cabin;
    @Column(name = "embarked") private String embarked;

    public Passenger(){}
    @Builder
    public Passenger(int survived,
                 int pclass,
                 String name,
                 String gender,
                 String age,
                 String sibSp,
                 String parch,
                 String ticket,
                 String fare,
                 String cabin,
                 String embarked) {
        this.survived = survived;
        this.pclass = pclass;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.sibSp = sibSp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
    }
}
