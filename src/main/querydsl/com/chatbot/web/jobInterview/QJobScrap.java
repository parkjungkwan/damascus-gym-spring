package com.chatbot.web.jobInterview;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJobScrap is a Querydsl query type for JobScrap
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJobScrap extends EntityPathBase<JobScrap> {

    private static final long serialVersionUID = 338394700L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJobScrap jobScrap = new QJobScrap("jobScrap");

    public final QCorporation corporation;

    public final StringPath dateScrap = createString("dateScrap");

    public final NumberPath<Long> job_scrap_id = createNumber("job_scrap_id", Long.class);

    public final QPublicRelation publicRelation;

    public QJobScrap(String variable) {
        this(JobScrap.class, forVariable(variable), INITS);
    }

    public QJobScrap(Path<? extends JobScrap> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJobScrap(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJobScrap(PathMetadata metadata, PathInits inits) {
        this(JobScrap.class, metadata, inits);
    }

    public QJobScrap(Class<? extends JobScrap> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.corporation = inits.isInitialized("corporation") ? new QCorporation(forProperty("corporation")) : null;
        this.publicRelation = inits.isInitialized("publicRelation") ? new QPublicRelation(forProperty("publicRelation")) : null;
    }

}

