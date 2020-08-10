package com.chatbot.web.coach;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChallenge is a Querydsl query type for Challenge
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChallenge extends EntityPathBase<Challenge> {

    private static final long serialVersionUID = 1157364073L;

    public static final QChallenge challenge = new QChallenge("challenge");

    public final NumberPath<Long> challengeId = createNumber("challengeId", Long.class);

    public final StringPath challengeName = createString("challengeName");

    public final StringPath challengePhoto = createString("challengePhoto");

    public final StringPath challengeText = createString("challengeText");

    public final ListPath<Exercise, QExercise> Exercises = this.<Exercise, QExercise>createList("Exercises", Exercise.class, QExercise.class, PathInits.DIRECT2);

    public QChallenge(String variable) {
        super(Challenge.class, forVariable(variable));
    }

    public QChallenge(Path<? extends Challenge> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChallenge(PathMetadata metadata) {
        super(Challenge.class, metadata);
    }

}

