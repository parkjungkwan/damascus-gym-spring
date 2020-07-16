package com.chatbot.web.member;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    private String email;

    private String nickname;

    private String password;

    private String phone;

    private String name;

    private String ssn;

    private String gender;

    private LocalDateTime joinDate;

    private String joinWay;

    private LocalDateTime withdrawal;

    private int admin;

    private int volunteerScore;

    private int volunteerScoreCount;

    private int requestScore;

    private int requestScoreCount;

    private int point;
}