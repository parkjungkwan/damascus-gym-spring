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

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Report
 */

@Component
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "reports")
public class Report implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id") private Long reportId;
    @Column(name = "report_date") private String reportDate;
    @Column(name = "report_cal_out") private String reportCalOut;
    @Column(name = "report_cal_in") private String reportCalIn;

    @ManyToOne
    @JoinColumn(name = "member_id") private Member memberId;

    @Builder
    private Report(String reportDate, String reportCalOut, String reportCalIn){

        this.reportDate = reportDate;
        this.reportCalOut = reportCalOut;
        this.reportCalIn = reportCalIn;
    }
}
