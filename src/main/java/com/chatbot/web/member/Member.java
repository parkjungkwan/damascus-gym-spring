package com.chatbot.web.member;

import com.chatbot.web.volunteer.Volunteer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Getter @Setter @ToString @NoArgsConstructor
@Table(name = "member", uniqueConstraints = {@UniqueConstraint(columnNames = {"nickname"})})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id") private Long id;
    @Column(name = "email") private String email;
    @Column(name = "nickname") private String nickname;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password") private String password;
    @Column(name = "phone") private String phone;
    @Column(name = "name") private String name;
    @Column(name = "ssn") private String ssn;
    @Column(name = "gender") private String gender;
    @CreationTimestamp
    @Column(name = "join_date") private LocalDateTime joinDate;
    @Column(name = "join_way", nullable = false) private String joinWay;
    @CreationTimestamp
    @Column(name = "withdrawal") private LocalDateTime withdrawal;
    @Column(name = "admin", nullable = false, columnDefinition = "boolean default 0") private int admin;
    @Column(name = "volunteer_score", nullable = false) private int volunteerScore;
    @Column(name = "volunteer_score_count", nullable = false) private int volunteerScoreCount;
    @Column(name = "request_score", nullable = false) private int requestScore;
    @Column(name = "request_score_count", nullable = false) private int requestScoreCount;
    @Column(name = "point", nullable = false) private int point;
    @JsonIgnore
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Volunteer> volunteers;

    @Builder
    private Member(String email,
                   String nickname,
                    String password,
                    String phone,
                    String name,
                    String ssn,
                    String gender,
                   LocalDateTime joinDate,
                   String joinWay,
                   LocalDateTime withdrawal,
                    int admin,
                    int volunteerScore,
                    int requestScoreCount,
                   int point) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.ssn = ssn;
        this.gender = gender;
        this.joinDate = joinDate;
        this.joinWay = joinWay;
        this.withdrawal = withdrawal;
        this.admin = admin;
        this.volunteerScore = volunteerScore;
        this.requestScoreCount = requestScoreCount;
        this.point = point;
    }
}

