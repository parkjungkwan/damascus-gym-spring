package com.chatbot.web.jobInterview;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Getter
@Setter
@Table(name = "job_alive")
public class JobAlive {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="job_alive_id") private Long jobAliveId;
    @Column(name="corpor_id") private Long corporId;
    @Column(name="corpor_name") private String corporName;
    @Column(name="state") private String state;
    @Column(name="start_date") private String startDate;
    @Column(name="start_time") private String startTime;
    @Column(name="area") private String area;
    @Column(name="career") private String career;
    @Column(name="url") private String url;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "alive")
    private List<Awaiter> awaiters;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_seq")
    private JobNotice jobNotice;

    @Builder
    private JobAlive(Long corporId, String corporName, String state, String startDate, String startTime,
                  String area, String career, String url){
        this.corporId = corporId;
        this.corporName = corporName;
        this.state = state;
        this.startDate = startDate;
        this.startTime = startTime;
        this.area = area;
        this.career = career;
        this.url = url;
    }
}
