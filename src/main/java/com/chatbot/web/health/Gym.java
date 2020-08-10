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
@ToString(exclude = "coaches")
@Table(name = "gyms")
public class Gym implements Serializable{
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gym_id") private Long gymId;
    @Column(name ="gym_name")private String gymName;
    @Column(name = "gym_info")private String gymInfo;
    @Column(name = "gym_info1")private String gymInfo1;
    @Column(name = "gym_info2")private String gymInfo2;
    @Column(name = "gym_info3")private String gymInfo3;
    @Column(name = "gym_price")private String gymPrice;
    @Column(name = "gym_time")private String gymTime;
    @Column(name = "gym_loc") private String gymLoc;
    @Column(name = "gym_photo") private String gymPhoto;


    @OneToMany(mappedBy = "gymId")
    @JsonIgnore
    private List<Coach> coaches = new ArrayList<>();

    @Builder
    private Gym(String gymName,String gymInfo, String gymInfo1,String gymInfo2,String gymInfo3,String gymPrice, String gymTime, String gymLoc, String gymPhoto ) {
        this.gymName = gymName;
        this.gymInfo = gymInfo;
        this.gymInfo1 = gymInfo1;
        this.gymInfo2 = gymInfo2;
        this.gymInfo3 = gymInfo3;
        this.gymPrice = gymPrice;
        this.gymTime = gymTime;
        this.gymLoc = gymLoc;
        this.gymPhoto = gymPhoto;
    }
}
