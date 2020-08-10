package com.chatbot.web.jobAlive;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "public_relation")
public class PublicRelation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long pr_id;

    @Column(name="itv_seq") private Long itvSeq;
    @Column(name="phone") private String phone;
    @Column(name="name") private String name;
    @Column(name="title") private String title;
    @Column(name="content") private String content;
    @Column(name="area") private String area;
    @Column(name="tag_location") private String tagLocation;
    @Column(name="tag_attribute") private String tagAttribute;
    @Column(name="tag_career") private String tagCareer;
    @Column(name="date_upload") private String dateUpload;
    @Column(name="pr_location") private String prLocation;
    @Column(name="url") private String url;
    @Column(name="email") private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pr")
    private List<JobScrap> scraps;

   @Builder
    private PublicRelation(Long itvSeq, String phone, String name,
               String title, String content, String area, String tagLocation, String tagAttribute,
               String tagCareer, String dateUpload, String prLocation, String url, String email){
        this.itvSeq = itvSeq;
        this.phone =phone;
        this.name = name;
        this.title = title;
        this.content = content;
        this.area = area;
        this.tagLocation = tagLocation;
        this.tagAttribute = tagAttribute;
        this.tagCareer = tagCareer;
        this.dateUpload = dateUpload;
        this.prLocation = prLocation;
        this.url = url;
        this.email = email;
    }
}
