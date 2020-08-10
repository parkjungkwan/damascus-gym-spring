package com.chatbot.web.employment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWorkMember is a Querydsl query type for WorkMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkMember extends EntityPathBase<WorkMember> {

    private static final long serialVersionUID = 1642648167L;

    public static final QWorkMember workMember = new QWorkMember("workMember");

    public final NumberPath<Integer> admin = createNumber("admin", Integer.class);

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> joinDate = createDateTime("joinDate", java.time.LocalDateTime.class);

    public final StringPath joinWay = createString("joinWay");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final NumberPath<Integer> requestScore = createNumber("requestScore", Integer.class);

    public final NumberPath<Integer> requestScoreCount = createNumber("requestScoreCount", Integer.class);

    public final StringPath ssn = createString("ssn");

    public final ListPath<Volunteer, QVolunteer> volunteers = this.<Volunteer, QVolunteer>createList("volunteers", Volunteer.class, QVolunteer.class, PathInits.DIRECT2);

    public final NumberPath<Integer> volunteerScore = createNumber("volunteerScore", Integer.class);

    public final NumberPath<Integer> volunteerScoreCount = createNumber("volunteerScoreCount", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> withdrawal = createDateTime("withdrawal", java.time.LocalDateTime.class);

    public QWorkMember(String variable) {
        super(WorkMember.class, forVariable(variable));
    }

    public QWorkMember(Path<? extends WorkMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkMember(PathMetadata metadata) {
        super(WorkMember.class, metadata);
    }

}

