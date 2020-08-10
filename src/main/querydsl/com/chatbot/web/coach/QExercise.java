package com.chatbot.web.coach;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QExercise is a Querydsl query type for Exercise
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QExercise extends EntityPathBase<Exercise> {

    private static final long serialVersionUID = -1138177006L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QExercise exercise = new QExercise("exercise");

    public final QChallenge challengeId;

    public final StringPath exerciseCal = createString("exerciseCal");

    public final StringPath exerciseCount = createString("exerciseCount");

    public final NumberPath<Long> exerciseId = createNumber("exerciseId", Long.class);

    public final StringPath exerciseName = createString("exerciseName");

    public final StringPath exerciseSet = createString("exerciseSet");

    public final StringPath exerciseText = createString("exerciseText");

    public final StringPath exerciseVideo = createString("exerciseVideo");

    public final ListPath<MyExercise, QMyExercise> myExercises = this.<MyExercise, QMyExercise>createList("myExercises", MyExercise.class, QMyExercise.class, PathInits.DIRECT2);

    public QExercise(String variable) {
        this(Exercise.class, forVariable(variable), INITS);
    }

    public QExercise(Path<? extends Exercise> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QExercise(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QExercise(PathMetadata metadata, PathInits inits) {
        this(Exercise.class, metadata, inits);
    }

    public QExercise(Class<? extends Exercise> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.challengeId = inits.isInitialized("challengeId") ? new QChallenge(forProperty("challengeId")) : null;
    }

}

