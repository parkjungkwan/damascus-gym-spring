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
 * Corporation
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "corporation")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Corporation implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long corpor_id;

    @Column(name = "corpor_code") private String corporCode;
    @Column(name = "password") private String password;
    @Column(name = "corpor_reg_num") private String corporRegNum;
    @Column(name = "corpor_name") private String corporName;
    @Column(name = "ceo_name") private String ceoName;
    @Column(name = "area") private String area;
    @Column(name = "pm_name") private String pmName;
    @Column(name = "pm_phone") private String pmPhone;
    @Column(name = "pm_email") private String pmEmail;
    @Column(name = "homepage") private String homepage;
    @Column(name = "city") private String city;
    @Column(name = "date_join") private String dateJoin;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "corporation")
    private List<JobScrap> scraps;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "corporation")
    private List<JobNotice> notices;

    @Builder
    private Corporation(String corporCode,String password, String corporRegNum, String corporName, String ceoName,
                        String area, String pmName, String pmPhone, String pmEmail, String homepage, String city, String dateJoin) {
        this.corporCode = corporCode;
        this.password = password;
        this.corporRegNum = corporRegNum;
        this.corporName = corporName;
        this.ceoName = ceoName;
        this.area = area;
        this.pmName = pmName;
        this.pmPhone = pmPhone;
        this.pmEmail = pmEmail;
        this.homepage = homepage;
        this.city = city;
        this.dateJoin = dateJoin;
    }
}
