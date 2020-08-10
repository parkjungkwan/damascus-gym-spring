package com.chatbot.web.gram;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoom is a Querydsl query type for Room
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoom extends EntityPathBase<Room> {

    private static final long serialVersionUID = -1709956308L;

    public static final QRoom room = new QRoom("room");

    public final ListPath<Member, QMember> members = this.<Member, QMember>createList("members", Member.class, QMember.class, PathInits.DIRECT2);

    public final StringPath roomcategory = createString("roomcategory");

    public final NumberPath<Integer> roomcharge = createNumber("roomcharge", Integer.class);

    public final StringPath roomdate = createString("roomdate");

    public final StringPath roomdetail = createString("roomdetail");

    public final StringPath roomhostid = createString("roomhostid");

    public final NumberPath<Double> roomlatitude = createNumber("roomlatitude", Double.class);

    public final NumberPath<Double> roomlongitude = createNumber("roomlongitude", Double.class);

    public final NumberPath<Long> roomno = createNumber("roomno", Long.class);

    public final NumberPath<Integer> roompenaltyall = createNumber("roompenaltyall", Integer.class);

    public final StringPath roomphoto = createString("roomphoto");

    public final StringPath roomplace = createString("roomplace");

    public final NumberPath<Integer> roomprogress = createNumber("roomprogress", Integer.class);

    public final StringPath roompwd = createString("roompwd");

    public final StringPath roomtitle = createString("roomtitle");

    public QRoom(String variable) {
        super(Room.class, forVariable(variable));
    }

    public QRoom(Path<? extends Room> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoom(PathMetadata metadata) {
        super(Room.class, metadata);
    }

}

