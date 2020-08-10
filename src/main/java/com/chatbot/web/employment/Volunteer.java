package com.chatbot.web.employment;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Getter @Setter @NoArgsConstructor
@ToString(exclude = {"member","article"})
@Table(name = "volunteer")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volunteer_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id") private WorkMember member;

    @ManyToOne
    @JoinColumn(name = "work_id") private WorkArticle article;

    @CreationTimestamp @Column(name = "volunteer_date")
    private LocalDateTime volunteerDate;

    @Builder
    private Volunteer(WorkMember member,
                      WorkArticle article,
                      LocalDateTime volunteerDate) {
        this.member = member;
        this.article = article;
        this.volunteerDate = volunteerDate;
    }
}
