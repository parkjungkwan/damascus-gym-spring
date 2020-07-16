package com.chatbot.web.article;

import com.chatbot.web.volunteer.Volunteer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Getter @Setter @ToString @NoArgsConstructor
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id") private Long id;
    @Column(name = "title", nullable = false) private String title;
    @CreationTimestamp
    @Column(name = "write_date") private LocalDateTime writeDate;
    @Column(name = "recruit", nullable = false) private String recruit;
    @Column(name = "work_day", nullable = false) private String workDay;
    @Column(name = "work_time", nullable = false) private String workTime;
    @Column(name = "work_age", nullable = false) private String workAge;
    @Column(name = "city_area", nullable = false) private String cityArea;
    @Column(name = "day_salary", nullable = false) private int daySalary;
    @Column(name = "total_salary", nullable = false) private int totalSalary;
    @Column(name = "contents", nullable = false) private String contents;
    @Column(name = "write_data_day", nullable = false) private int writeDataDay;
    @Column(name = "kakao", nullable = false) private String kakao;
    @Column(name = "progress_state", nullable = false) private String progressState;
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Volunteer> volunteers;


}
