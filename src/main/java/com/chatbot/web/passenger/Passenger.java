package com.chatbot.web.passenger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @Column(name = "pass_id") private Long passId;
    @Column(name = "PassengerId", nullable = false) private String email;
    @Column(name = "Survived", nullable = false) private String email;
    @Column(name = "Pclass", nullable = false) private String email;
    @Column(name = "Name", nullable = false) private String email;
    @Column(name = "Sex", nullable = false) private String email;
    @Column(name = "Age", nullable = false) private String email;
    @Column(name = "SibSp", nullable = false) private String email;
    @Column(name = "Parch", nullable = false) private String email;
    @Column(name = "Ticket", nullable = false) private String email;
    @Column(name = "Fare", nullable = false) private String email;
    @Column(name = "Cabin", nullable = false) private String email;
    @Column(name = "Embarked", nullable = false) private String email;
}
