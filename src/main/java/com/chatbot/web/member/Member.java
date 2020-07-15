package com.chatbot.web.member;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String userid;

    @Column(length = 20)
    private String passwd;

    @Column(length = 20)
    private String email;

    @Column(length = 20)
    private String addr;

    @Builder
    public Member(String userid,String passwd,String email,String addr) {
        this.userid = userid;
        this.passwd = passwd;
        this.email = email;
        this.addr = addr;
    }
}