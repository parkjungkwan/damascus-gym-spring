package com.chatbot.web.coach;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * member
 */

@Component
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString(callSuper = true, exclude = {"coaches", "myExercises", "diaries" })
@Table(name = "members")
public class GymMember implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id") private Long memberId;
    @Column(name = "member_type", nullable = false) private Integer                memberType;
    @Column(name = "member_email", nullable = false, unique = true) private String memberEmail;
    @Column(name = "member_pw", nullable = false)private String                    memberPw;
    @Column(name = "member_name", nullable = false) private String                 memberName;
    @Column(name = "member_height") private String                                 memberHeight;
    @Column(name = "member_weight") private String                                 memberWeight;
    @Column(name = "member_photo") private String                                  memberPhoto;
    @Column(name = "member_text") private String                                   memberText;

    @OneToMany(mappedBy = "memberId",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Report> reports = new ArrayList<>();

    @OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Meal> meals = new ArrayList<>();

    @OneToMany(mappedBy = "memberId",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Diary> diaries = new ArrayList<>();

    @OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Coach> coaches = new ArrayList<>();

    @OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MyExercise> myExercises = new ArrayList<>();

    @OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MyChallenge> myChallenges = new ArrayList<>();

    @Builder
    private GymMember(String memberEmail, String memberPw, Integer memberType, String memberName,
                      String memberHeight, String memberWeight, String memberPhoto, String memberText){

        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.memberType = memberType;
        this.memberName = memberName;
        this.memberHeight = memberHeight;
        this.memberWeight = memberWeight;
        this.memberPhoto = memberPhoto;
        this.memberText = memberText;
    }
}
