package com.chatbot.web.jobAlive;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPublicRelation is a Querydsl query type for PublicRelation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPublicRelation extends EntityPathBase<PublicRelation> {

    private static final long serialVersionUID = -444497475L;

    public static final QPublicRelation publicRelation = new QPublicRelation("publicRelation");

    public final StringPath area = createString("area");

    public final StringPath content = createString("content");

    public final StringPath dateUpload = createString("dateUpload");

    public final StringPath email = createString("email");

    public final NumberPath<Long> itvSeq = createNumber("itvSeq", Long.class);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final NumberPath<Long> pr_id = createNumber("pr_id", Long.class);

    public final StringPath prLocation = createString("prLocation");

    public final ListPath<JobScrap, QJobScrap> scraps = this.<JobScrap, QJobScrap>createList("scraps", JobScrap.class, QJobScrap.class, PathInits.DIRECT2);

    public final StringPath tagAttribute = createString("tagAttribute");

    public final StringPath tagCareer = createString("tagCareer");

    public final StringPath tagLocation = createString("tagLocation");

    public final StringPath title = createString("title");

    public final StringPath url = createString("url");

    public QPublicRelation(String variable) {
        super(PublicRelation.class, forVariable(variable));
    }

    public QPublicRelation(Path<? extends PublicRelation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPublicRelation(PathMetadata metadata) {
        super(PublicRelation.class, metadata);
    }

}

