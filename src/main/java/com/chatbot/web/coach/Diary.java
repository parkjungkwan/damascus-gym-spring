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

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Diary
 */
@Component
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@Table(name = "diaries")
public class Diary implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id") private Long diaryId;
    @Column(name = "diary_date") private String diaryDate;
    @Column(name = "diary_photo") private String diaryPhoto;
    @Column(name = "diary_days") private String diaryDays;
    @Column(name = "diary_goal") private String diaryGoal;
    @Column(name = "diary_fat") private String diaryFat;
    @Column(name = "diary_water") private String diaryWater;
    @Column(name = "diary_muscle") private String diaryMuscle;
    @Column(name = "diary_skeletal") private String diarySkeletal;
    @Column(name = "diary_comment") private String diaryComment;

    @ManyToOne
    @JoinColumn(name = "member_id") private GymMember gymMemberId;

    @Builder
    private Diary(String diaryDate, String diaryPhoto, String diaryDays, String diaryGoal,
                    String diaryFat, String diaryWater, String diaryMuscle, String diarySkeletal, String diaryComment){

        this.diaryDate = diaryDate;
        this.diaryPhoto = diaryPhoto;
        this.diaryDays = diaryDays;
        this.diaryGoal = diaryGoal;
        this.diaryFat = diaryFat;
        this.diaryWater = diaryWater;
        this.diaryMuscle = diaryMuscle;
        this.diarySkeletal = diarySkeletal;
        this.diaryComment = diaryComment;
    }
}
