package com.chatbot.web.jobInterview;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAwaiter is a Querydsl query type for Awaiter
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAwaiter extends EntityPathBase<Awaiter> {

    private static final long serialVersionUID = -1790300853L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAwaiter awaiter = new QAwaiter("awaiter");

    public final NumberPath<Long> awaiterId = createNumber("awaiterId", Long.class);

    public final QInterviewer interviewer;

    public final QJobAlive jobAlive;

    public final StringPath result = createString("result");

    public QAwaiter(String variable) {
        this(Awaiter.class, forVariable(variable), INITS);
    }

    public QAwaiter(Path<? extends Awaiter> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAwaiter(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAwaiter(PathMetadata metadata, PathInits inits) {
        this(Awaiter.class, metadata, inits);
    }

    public QAwaiter(Class<? extends Awaiter> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.interviewer = inits.isInitialized("interviewer") ? new QInterviewer(forProperty("interviewer")) : null;
        this.jobAlive = inits.isInitialized("jobAlive") ? new QJobAlive(forProperty("jobAlive"), inits.get("jobAlive")) : null;
    }

}

