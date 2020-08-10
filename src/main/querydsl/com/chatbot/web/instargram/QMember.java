package com.chatbot.web.instargram;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<GramMember> {

    private static final long serialVersionUID = 1552014507L;

    public static final QMember member = new QMember("member1");

    public final StringPath birthday = createString("birthday");

    public final StringPath email = createString("email");

    public final StringPath gender = createString("gender");

    public final StringPath memberid = createString("memberid");

    public final NumberPath<Integer> money = createNumber("money", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final StringPath profileimage = createString("profileimage");

    public final StringPath pwd = createString("pwd");

    public final ListPath<GramRoom, QRoom> rooms = this.<GramRoom, QRoom>createList("rooms", GramRoom.class, QRoom.class, PathInits.DIRECT2);

    public final StringPath tardystate = createString("tardystate");

    public QMember(String variable) {
        super(GramMember.class, forVariable(variable));
    }

    public QMember(Path<? extends GramMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(GramMember.class, metadata);
    }

}

