package com.chatbot.web.coach;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * Exercise
 */
@Component
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString(exclude = "challengeId")
@Table(name = "exercises")
public class Exercise  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id") private Long exerciseId;
    @Column(name = "exercise_name", nullable = false) private String exerciseName;
    @Column(name = "exercise_set") private String exerciseSet;
    @Column(name = "exercise_count") private String exerciseCount;
    @Column(name = "exercise_video") private String exerciseVideo;
    @Column(name = "exercise_text") private String exerciseText;
    @Column(name = "exercise_cal") private String exerciseCal;

    @OneToMany(mappedBy = "exerciseId")
    @JsonIgnore
    private List<MyExercise> myExercises = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    @JsonIgnore
    private Challenge challengeId;

    @Builder
    private Exercise(String exerciseName, String exerciseSet, String exerciseCount,
                     String exerciseVideo, String exerciseText, String exerciseCal){

        this.exerciseName = exerciseName;
        this.exerciseSet = exerciseSet;
        this.exerciseCount = exerciseCount;
        this.exerciseVideo = exerciseVideo;
        this.exerciseText = exerciseText;
        this.exerciseCal = exerciseCal;
    }
}
