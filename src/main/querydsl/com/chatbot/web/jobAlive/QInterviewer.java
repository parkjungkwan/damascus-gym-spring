package com.chatbot.web.jobAlive;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInterviewer is a Querydsl query type for Interviewer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInterviewer extends EntityPathBase<Interviewer> {

    private static final long serialVersionUID = -2087484746L;

    public static final QInterviewer interviewer = new QInterviewer("interviewer");

    public final StringPath area = createString("area");

    public final ListPath<Awaiter, QAwaiter> awaiters = this.<Awaiter, QAwaiter>createList("awaiters", Awaiter.class, QAwaiter.class, PathInits.DIRECT2);

    public final StringPath birth = createString("birth");

    public final StringPath dateJoin = createString("dateJoin");

    public final StringPath email = createString("email");

    public final StringPath interviewerCode = createString("interviewerCode");

    public final NumberPath<Long> interviewerId = createNumber("interviewerId", Long.class);

    public final StringPath location = createString("location");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public QInterviewer(String variable) {
        super(Interviewer.class, forVariable(variable));
    }

    public QInterviewer(Path<? extends Interviewer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInterviewer(PathMetadata metadata) {
        super(Interviewer.class, metadata);
    }

}

