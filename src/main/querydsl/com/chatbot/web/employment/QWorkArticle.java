package com.chatbot.web.employment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWorkArticle is a Querydsl query type for WorkArticle
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkArticle extends EntityPathBase<WorkArticle> {

    private static final long serialVersionUID = 1996193481L;

    public static final QWorkArticle workArticle = new QWorkArticle("workArticle");

    public final StringPath cityArea = createString("cityArea");

    public final StringPath contents = createString("contents");

    public final NumberPath<Integer> daySalary = createNumber("daySalary", Integer.class);

    public final StringPath kakao = createString("kakao");

    public final StringPath progressState = createString("progressState");

    public final StringPath recruit = createString("recruit");

    public final StringPath title = createString("title");

    public final NumberPath<Integer> totalSalary = createNumber("totalSalary", Integer.class);

    public final ListPath<Volunteer, QVolunteer> volunteers = this.<Volunteer, QVolunteer>createList("volunteers", Volunteer.class, QVolunteer.class, PathInits.DIRECT2);

    public final StringPath workAge = createString("workAge");

    public final StringPath workDay = createString("workDay");

    public final NumberPath<Long> workId = createNumber("workId", Long.class);

    public final StringPath workTime = createString("workTime");

    public final NumberPath<Integer> writeDataDay = createNumber("writeDataDay", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> writeDate = createDateTime("writeDate", java.time.LocalDateTime.class);

    public QWorkArticle(String variable) {
        super(WorkArticle.class, forVariable(variable));
    }

    public QWorkArticle(Path<? extends WorkArticle> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkArticle(PathMetadata metadata) {
        super(WorkArticle.class, metadata);
    }

}

