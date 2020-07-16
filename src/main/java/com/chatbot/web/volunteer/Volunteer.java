package com.chatbot.web.volunteer;

import com.chatbot.web.article.Article;
import com.chatbot.web.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
    @JoinColumn(name = "member_id") private Member member;

    @ManyToOne
    @JoinColumn(name = "work_id") private Article article;

    @CreationTimestamp @Column(name = "volunteer_date")
    private LocalDateTime volunteerDate;


}
