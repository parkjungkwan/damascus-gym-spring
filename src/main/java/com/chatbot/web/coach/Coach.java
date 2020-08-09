package com.chatbot.web.coach;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Getter
@Setter
@ToString
@Table (name = "coaches")
public class Coach implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id") private Long coachId;

    @Column(name="coach_loc") private String coachLoc;
    @Column(name="coach_info") private String coachInfo;
    @Column(name="coach_link") private String coachLink;
    @Column(name="coach_photo1") private String coachPhoto1;
    @Column(name="coach_photo2") private String coachPhoto2;
    @Column(name="coach_name") private String coachName;
    @Column(name="coach_resume1") private String coachResume1;
    @Column(name="coach_resume2") private String coachResume2;
    @Column(name="coach_resume3") private String coachResume3;
    @Column(name="coach_resume4") private String coachResume4;
    @Column(name="coach_resume5") private String coachResume5;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "member_id") private Member memberId;

    @ManyToOne
    @JoinColumn(name = "gym_id") private Gym gymId;

    @Builder
    public Coach(Long coachId,  String coachLoc, String coachInfo, String coachPhoto1,String coachPhoto2, String coachName,
                   String coachLink, String coachResume1, String coachResume2, String coachResume3,String coachResume4,String coachResume5) {
        this.coachId = coachId;
        this.coachLoc = coachLoc;
        this.coachInfo = coachInfo;
        this.coachLink = coachLink;
        this.coachPhoto1 = coachPhoto1;
        this.coachPhoto2 = coachPhoto2;
        this.coachName = coachName;
        this.coachResume1 = coachResume1;
        this.coachResume2 = coachResume2;
        this.coachResume3 = coachResume3;
        this.coachResume4 = coachResume4;
        this.coachResume5 = coachResume5;
    }
}
