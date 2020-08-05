package com.chatbot.web.progress;

import lombok.*;

import javax.persistence.*;

@Entity @Getter @Setter @ToString @NoArgsConstructor
@Table(name = "progress")
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_id")
    private Long id;
    @Column(name = "progress_title") private String progressTitle;

    @Builder
    Progress(String progressTitle){
        this.progressTitle = progressTitle;
    }


}
