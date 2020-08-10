package com.chatbot.web.instargram;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.ColumnDefault;

import lombok.Data;
import lombok.ToString;

@Data
@Table(name = "tbl_room")
@Entity
@ToString
public class GramRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomno; //미팅의 번호
    private String roomtitle;//미팅의 제목
    private String roomdetail; //미팅의 상세내용
    private String roomdate; //미팅날짜
    private String roomplace; //미팅장소
    private String roomcategory; //미팅카테고리 ex)동창회, 스터디
    @ColumnDefault("1")
    private int roomprogress; //현재진행중이면1 끝나면0
    private int roomcharge; //벌금
    private double roomlatitude; //위도
    private double roomlongitude; //경도
    private String roomphoto; //모임장소 사진
    private String roomhostid; //로그인한방장의 아이디
    private String roompwd;
    @ColumnDefault("0")
    private int roompenaltyall;

    //연관관계의 주인은 Member가됨
    @ManyToMany(mappedBy = "rooms")
    @JsonIgnore
    private List<GramMember> members = new ArrayList<>();

    public void addMember(GramMember member) {
        members.add(member);
    }


}
