package com.chatbot.web.health;
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
 * Meal
 */
@Component
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Table(name = "meals")
public class Meal implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id") private Long mealId;
    @Column(name = "meal_date") private String mealDate;
    @Column(name = "meal_time") private String mealTime;
    @Column(name = "meal_cal") private String mealCal;

    @ManyToOne
    @JoinColumn(name = "member_id") private GymMember gymMemberId;

    @ManyToOne
    @JoinColumn(name = "food_id") private Food foodId;

    @Builder
    private Meal(String mealDate, String mealTime, String mealCal){

        this.mealDate = mealDate;
        this.mealTime = mealTime;
        this.mealCal = mealCal;
    }
}
