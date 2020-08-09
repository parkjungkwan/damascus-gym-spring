package com.chatbot.web.gram;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@Table(name = "tbl_members")
@NoArgsConstructor
public class Member {
    @Id
    private String memberid;
    private String pwd;
    private String name;
    private String birthday;
    private String email;
    private String gender;
    private String phone;
    private String profileimage;
    @ColumnDefault("0")
    private int money;
    private String tardystate;

    public Member(String memberid) {
        super();
        this.memberid = memberid;
    }

    //단방향 혹은 양방향으로 매핑되어 있는 엔티티에 대해
    //어느 한쪽 엔티티의 상태(생성 혹은 삭제)가 변경되었을 시 그에 따른 변화를 바인딩된 엔티티들에게 전파
    // @ManyToMany(cascade = CascadeType.ALL)
    // private List<Room> rooms = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();


    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    @Override
    public String toString(){
        return "Member ::::: memberid:"+memberid+",pwd:" +pwd+", name:"+name+", birthday:"+birthday+", email:"+email+
                ", gender:"+gender+", phone:"+phone+", profileimage:"+profileimage+", money:"+money+"";
    }


}
