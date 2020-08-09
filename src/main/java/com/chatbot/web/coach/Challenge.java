package com.chatbot.web.coach;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * Challenge
 */
@Entity
@Component
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@Table(name = "challenge")
public class Challenge  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_id") Long challengeId;
    @Column(name = "challenge_name", nullable = false, unique = true) private String challengeName;
    @Column(name = "challenge_text") private String challengeText;
    @Column(name = "challenge_photo") private String challengePhoto;

    @OneToMany(mappedBy = "challengeId", orphanRemoval = true , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Exercise> Exercises = new ArrayList<>();

    @Builder
    private Challenge(String challengeName, String challengeText, String challengePhoto){
        this.challengeName = challengeName;
        this.challengeText = challengeText;
        this.challengePhoto = challengePhoto;
    }
}
