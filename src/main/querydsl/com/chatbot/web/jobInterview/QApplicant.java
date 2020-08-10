package com.chatbot.web.jobInterview;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QApplicant is a Querydsl query type for Applicant
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QApplicant extends EntityPathBase<Applicant> {

    private static final long serialVersionUID = -1303662134L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QApplicant applicant = new QApplicant("applicant");

    public final NumberPath<Long> applicantSeq = createNumber("applicantSeq", Long.class);

    public final StringPath appState = createString("appState");

    public final NumberPath<Long> itvSeq = createNumber("itvSeq", Long.class);

    public final QJobNotice jobNotice;

    public QApplicant(String variable) {
        this(Applicant.class, forVariable(variable), INITS);
    }

    public QApplicant(Path<? extends Applicant> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QApplicant(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QApplicant(PathMetadata metadata, PathInits inits) {
        this(Applicant.class, metadata, inits);
    }

    public QApplicant(Class<? extends Applicant> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jobNotice = inits.isInitialized("jobNotice") ? new QJobNotice(forProperty("jobNotice"), inits.get("jobNotice")) : null;
    }

}

