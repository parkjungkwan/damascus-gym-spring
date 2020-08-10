package com.chatbot.web.health;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Food
 */
@Component
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@Table(name = "foods")
public class Food implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id") private Long foodId;
    @Column(name = "food_name", unique = true, nullable = false) private String foodName;
    @Column(name = "food_cal") private String foodCal;

    @OneToMany(mappedBy = "foodId")
    private List<Meal> meals = new ArrayList<>();

    @Builder
    private Food(String foodName, String foodCal){

        this.foodName = foodName;
        this.foodCal = foodCal;
    }
}
