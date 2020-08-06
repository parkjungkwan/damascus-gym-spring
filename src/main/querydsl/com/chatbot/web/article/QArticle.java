package com.chatbot.web.article;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticle is a Querydsl query type for Article
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArticle extends EntityPathBase<Article> {

    private static final long serialVersionUID = -267490984L;

    public static final QArticle article = new QArticle("article");

    public final StringPath cityArea = createString("cityArea");

    public final StringPath contents = createString("contents");

    public final NumberPath<Integer> daySalary = createNumber("daySalary", Integer.class);

    public final StringPath kakao = createString("kakao");

    public final StringPath progressState = createString("progressState");

    public final StringPath recruit = createString("recruit");

    public final StringPath title = createString("title");

    public final NumberPath<Integer> totalSalary = createNumber("totalSalary", Integer.class);

    public final ListPath<com.chatbot.web.volunteer.Volunteer, com.chatbot.web.volunteer.QVolunteer> volunteers = this.<com.chatbot.web.volunteer.Volunteer, com.chatbot.web.volunteer.QVolunteer>createList("volunteers", com.chatbot.web.volunteer.Volunteer.class, com.chatbot.web.volunteer.QVolunteer.class, PathInits.DIRECT2);

    public final StringPath workAge = createString("workAge");

    public final StringPath workDay = createString("workDay");

    public final NumberPath<Long> workId = createNumber("workId", Long.class);

    public final StringPath workTime = createString("workTime");

    public final NumberPath<Integer> writeDataDay = createNumber("writeDataDay", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> writeDate = createDateTime("writeDate", java.time.LocalDateTime.class);

    public QArticle(String variable) {
        super(Article.class, forVariable(variable));
    }

    public QArticle(Path<? extends Article> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticle(PathMetadata metadata) {
        super(Article.class, metadata);
    }

}

