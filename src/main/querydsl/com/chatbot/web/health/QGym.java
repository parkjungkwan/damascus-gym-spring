package com.chatbot.web.health;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGym is a Querydsl query type for Gym
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGym extends EntityPathBase<Gym> {

    private static final long serialVersionUID = 57592641L;

    public static final QGym gym = new QGym("gym");

    public final ListPath<Coach, QCoach> coaches = this.<Coach, QCoach>createList("coaches", Coach.class, QCoach.class, PathInits.DIRECT2);

    public final NumberPath<Long> gymId = createNumber("gymId", Long.class);

    public final StringPath gymInfo = createString("gymInfo");

    public final StringPath gymInfo1 = createString("gymInfo1");

    public final StringPath gymInfo2 = createString("gymInfo2");

    public final StringPath gymInfo3 = createString("gymInfo3");

    public final StringPath gymLoc = createString("gymLoc");

    public final StringPath gymName = createString("gymName");

    public final StringPath gymPhoto = createString("gymPhoto");

    public final StringPath gymPrice = createString("gymPrice");

    public final StringPath gymTime = createString("gymTime");

    public QGym(String variable) {
        super(Gym.class, forVariable(variable));
    }

    public QGym(Path<? extends Gym> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGym(PathMetadata metadata) {
        super(Gym.class, metadata);
    }

}

