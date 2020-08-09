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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * memChallenges
 */
@Component
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString(callSuper = true, exclude = {"memberId","myExercises"})
@Table(name = "my_challenges")
public class MyChallenge  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_challenge_id") private Long myChallengeId;
    @Column(name = "my_challenge_name") private String myChallengeName;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "member_id")
    private Member memberId;

    @OneToMany(mappedBy = "myChallengeId")
    @JsonIgnore
    private List<MyExercise> myExercises = new ArrayList<>();
}
