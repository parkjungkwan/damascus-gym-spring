package com.chatbot.web.jobInterview;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCorporation is a Querydsl query type for Corporation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCorporation extends EntityPathBase<Corporation> {

    private static final long serialVersionUID = -1565220656L;

    public static final QCorporation corporation = new QCorporation("corporation");

    public final StringPath area = createString("area");

    public final StringPath ceoName = createString("ceoName");

    public final StringPath city = createString("city");

    public final NumberPath<Long> corpor_id = createNumber("corpor_id", Long.class);

    public final StringPath corporCode = createString("corporCode");

    public final StringPath corporName = createString("corporName");

    public final StringPath corporRegNum = createString("corporRegNum");

    public final StringPath dateJoin = createString("dateJoin");

    public final StringPath homepage = createString("homepage");

    public final ListPath<JobNotice, QJobNotice> notices = this.<JobNotice, QJobNotice>createList("notices", JobNotice.class, QJobNotice.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final StringPath pmEmail = createString("pmEmail");

    public final StringPath pmName = createString("pmName");

    public final StringPath pmPhone = createString("pmPhone");

    public final ListPath<JobScrap, QJobScrap> scraps = this.<JobScrap, QJobScrap>createList("scraps", JobScrap.class, QJobScrap.class, PathInits.DIRECT2);

    public QCorporation(String variable) {
        super(Corporation.class, forVariable(variable));
    }

    public QCorporation(Path<? extends Corporation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCorporation(PathMetadata metadata) {
        super(Corporation.class, metadata);
    }

}

