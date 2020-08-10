package com.chatbot.web.jobInterview;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJobNotice is a Querydsl query type for JobNotice
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJobNotice extends EntityPathBase<JobNotice> {

    private static final long serialVersionUID = 1768304573L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJobNotice jobNotice = new QJobNotice("jobNotice");

    public final ListPath<Applicant, QApplicant> applicants = this.<Applicant, QApplicant>createList("applicants", Applicant.class, QApplicant.class, PathInits.DIRECT2);

    public final StringPath area = createString("area");

    public final StringPath career = createString("career");

    public final StringPath content = createString("content");

    public final QCorporation corporation;

    public final StringPath corporName = createString("corporName");

    public final QJobAlive jobAlive;

    public final NumberPath<Long> jobNoticeId = createNumber("jobNoticeId", Long.class);

    public final StringPath startDate = createString("startDate");

    public final StringPath startTime = createString("startTime");

    public final StringPath state = createString("state");

    public final StringPath tagAttribute = createString("tagAttribute");

    public final StringPath tagCareer = createString("tagCareer");

    public final StringPath tagLocation = createString("tagLocation");

    public final StringPath title = createString("title");

    public QJobNotice(String variable) {
        this(JobNotice.class, forVariable(variable), INITS);
    }

    public QJobNotice(Path<? extends JobNotice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJobNotice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJobNotice(PathMetadata metadata, PathInits inits) {
        this(JobNotice.class, metadata, inits);
    }

    public QJobNotice(Class<? extends JobNotice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.corporation = inits.isInitialized("corporation") ? new QCorporation(forProperty("corporation")) : null;
        this.jobAlive = inits.isInitialized("jobAlive") ? new QJobAlive(forProperty("jobAlive"), inits.get("jobAlive")) : null;
    }

}

