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

/**
 * MemExercise
 */

@Component
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@Table(name = "my_exercises")
public class MyExercise  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_exercise_id") private Long          myExerciseId;
    @Column(name = "my_exercise_date") private String      myExerciseDate;
    @Column(name = "my_exercise_time") private String      myExerciseTime;
    @Column(name = "my_exercise_cal") private String       myExerciseCal;
    @Column(name = "my_exercise_complete") private Boolean myExerciseComplete;
    @Column(name = "my_exercise_set") private String       myExerciseSet;
    @Column(name = "my_exercise_count") private String     myExerciseCount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "member_id") private Member memberId;

    @ManyToOne
    @JoinColumn(name = "exercise_id") private Exercise exerciseId;

    @ManyToOne
    @JoinColumn(name = "myChallenge_id")
    private MyChallenge myChallengeId;

    @Builder
    private MyExercise(String myExerciseDate, Boolean myExerciseComplete, String myExerciseTime, String myExerciseCal,
                        String myExerciseSet, String myExerciseCount){

        this.myExerciseDate = myExerciseDate;
        this.myExerciseComplete = myExerciseComplete;
        this.myExerciseTime = myExerciseTime;
        this.myExerciseCal = myExerciseCal;
        this.myExerciseCount = myExerciseCount;
        this.myExerciseSet = myExerciseSet;

    }
}
