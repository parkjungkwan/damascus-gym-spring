package com.chatbot.web.jobAlive;
import java.io.Serializable;
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

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Interviewer
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "interviewer")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Interviewer  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interviewer_id") private Long interviewerId;
    @Column(name = "interviewer_code") private String interviewerCode;
    @Column(name = "password") private String password;
    @Column(name = "name") private String name;
    @Column(name = "birth") private String birth;
    @Column(name = "phone") private String phone;
    @Column(name = "email") private String email;
    @Column(name = "area") private String area;
    @Column(name = "location") private String location;
    @Column(name = "date_join") private String dateJoin;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "interviewer")
    private List<Awaiter> awaiters;

    @Builder
    private Interviewer(String interviewerCode, String password, String name, String birth,String phone,
                        String email,String area,String location, String dateJoin){
        this.interviewerCode = interviewerCode;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.phone = phone;
        this.email = email;
        this.area = area;
        this.location = location;
        this.dateJoin = dateJoin;
    }
}
