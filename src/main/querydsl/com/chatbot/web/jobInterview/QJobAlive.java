package com.chatbot.web.jobInterview;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJobAlive is a Querydsl query type for JobAlive
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJobAlive extends EntityPathBase<JobAlive> {

    private static final long serialVersionUID = 322031432L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJobAlive jobAlive = new QJobAlive("jobAlive");

    public final StringPath area = createString("area");

    public final ListPath<Awaiter, QAwaiter> awaiters = this.<Awaiter, QAwaiter>createList("awaiters", Awaiter.class, QAwaiter.class, PathInits.DIRECT2);

    public final StringPath career = createString("career");

    public final NumberPath<Long> corporId = createNumber("corporId", Long.class);

    public final StringPath corporName = createString("corporName");

    public final NumberPath<Long> jobAliveId = createNumber("jobAliveId", Long.class);

    public final QJobNotice jobNotice;

    public final StringPath startDate = createString("startDate");

    public final StringPath startTime = createString("startTime");

    public final StringPath state = createString("state");

    public final StringPath url = createString("url");

    public QJobAlive(String variable) {
        this(JobAlive.class, forVariable(variable), INITS);
    }

    public QJobAlive(Path<? extends JobAlive> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJobAlive(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJobAlive(PathMetadata metadata, PathInits inits) {
        this(JobAlive.class, metadata, inits);
    }

    public QJobAlive(Class<? extends JobAlive> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jobNotice = inits.isInitialized("jobNotice") ? new QJobNotice(forProperty("jobNotice"), inits.get("jobNotice")) : null;
    }

}

