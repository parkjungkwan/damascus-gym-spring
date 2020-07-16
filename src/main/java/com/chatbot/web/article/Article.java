package com.chatbot.web.article;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Getter @Setter @ToString @NoArgsConstructor
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workId;

    private String title;

    private LocalDateTime writeDate;

    private String recruit;

    private String workDay;

    private String workTime;

    private String workAge;

    private String cityArea;

    private int daySalary;

    private int totalSalary;

    private String contents;

    private int writeDataDay;

    private String kakao;

    private String progressState;

}
