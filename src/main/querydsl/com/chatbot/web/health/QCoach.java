package com.chatbot.web.health;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCoach is a Querydsl query type for Coach
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCoach extends EntityPathBase<Coach> {

    private static final long serialVersionUID = -492047200L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCoach coach = new QCoach("coach");

    public final NumberPath<Long> coachId = createNumber("coachId", Long.class);

    public final StringPath coachInfo = createString("coachInfo");

    public final StringPath coachLink = createString("coachLink");

    public final StringPath coachLoc = createString("coachLoc");

    public final StringPath coachName = createString("coachName");

    public final StringPath coachPhoto1 = createString("coachPhoto1");

    public final StringPath coachPhoto2 = createString("coachPhoto2");

    public final StringPath coachResume1 = createString("coachResume1");

    public final StringPath coachResume2 = createString("coachResume2");

    public final StringPath coachResume3 = createString("coachResume3");

    public final StringPath coachResume4 = createString("coachResume4");

    public final StringPath coachResume5 = createString("coachResume5");

    public final QGym gymId;

    public final QGymMember gymMemberId;

    public QCoach(String variable) {
        this(Coach.class, forVariable(variable), INITS);
    }

    public QCoach(Path<? extends Coach> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCoach(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCoach(PathMetadata metadata, PathInits inits) {
        this(Coach.class, metadata, inits);
    }

    public QCoach(Class<? extends Coach> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gymId = inits.isInitialized("gymId") ? new QGym(forProperty("gymId")) : null;
        this.gymMemberId = inits.isInitialized("gymMemberId") ? new QGymMember(forProperty("gymMemberId")) : null;
    }

}

