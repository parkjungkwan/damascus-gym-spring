package com.chatbot.web.passenger;

import lombok.*;

import javax.persistence.*;

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
    @Column(name = "sex") private String sex;
    @Column(name = "age") private String age;
    @Column(name = "sib_sp") private String sib_sp;
    @Column(name = "parch") private String parch;
    @Column(name = "ticket") private String ticket;
    @Column(name = "fare") private String fare;
    @Column(name = "cabin") private String cabin;
    @Column(name = "embarked") private String embarked;
// PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked
    public Passenger(){}
    @Builder
    public Passenger(int survived,
                 int pclass,
                 String name,
                 String sex,
                 String age,
                 String sib_sp,
                 String parch,
                 String ticket,
                 String fare,
                 String cabin,
                 String embarked) {
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
