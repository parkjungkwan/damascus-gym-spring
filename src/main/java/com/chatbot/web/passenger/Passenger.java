package com.chatbot.web.passenger;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id") private Long passengerId;
    @Column(name = "passenger_number", nullable = false) private String passengerNumber;
    @Column(name = "survived", nullable = false) private String survived;
    @Column(name = "pclass") private String pclass;
    @Column(name = "name") private String name;
    @Column(name = "sex") private String sex;
    @Column(name = "age") private String age;
    @Column(name = "sib_sp") private String sib_sp;
    @Column(name = "parch") private String parch;
    @Column(name = "ticket") private String ticket;
    @Column(name = "fare") private String fare;
    @Column(name = "cabin") private String cabin;
    @Column(name = "embarked") private String embarked;

    @Override
    public String toString() {
        return String.format("Passenger[passenger_id=%d, passenger_number='%d', name='%s']",
                passengerId, passengerNumber, name);
    }
    @Builder
    private Passenger(String passengerNumber,
                 String survived,
                 String pclass,
                 String name,
                 String sex,
                 String age,
                 String sib_sp,
                 String parch,
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
