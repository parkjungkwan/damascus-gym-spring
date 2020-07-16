package com.chatbot.web.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1014359176L;

    public static final QMember member = new QMember("member1");

    public final NumberPath<Integer> admin = createNumber("admin", Integer.class);

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final DateTimePath<java.time.LocalDateTime> joinDate = createDateTime("joinDate", java.time.LocalDateTime.class);

    public final StringPath joinWay = createString("joinWay");

    public final NumberPath<Integer> memberId = createNumber("memberId", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final NumberPath<Integer> requestScore = createNumber("requestScore", Integer.class);

    public final NumberPath<Integer> requestScoreCount = createNumber("requestScoreCount", Integer.class);

    public final StringPath ssn = createString("ssn");

    public final NumberPath<Integer> volunteerScore = createNumber("volunteerScore", Integer.class);

    public final NumberPath<Integer> volunteerScoreCount = createNumber("volunteerScoreCount", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> withdrawal = createDateTime("withdrawal", java.time.LocalDateTime.class);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

