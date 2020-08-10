package com.chatbot.web.coach;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyExercise is a Querydsl query type for MyExercise
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyExercise extends EntityPathBase<MyExercise> {

    private static final long serialVersionUID = -791205026L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyExercise myExercise = new QMyExercise("myExercise");

    public final QExercise exerciseId;

    public final QGymMember gymMemberId;

    public final QMyChallenge myChallengeId;

    public final StringPath myExerciseCal = createString("myExerciseCal");

    public final BooleanPath myExerciseComplete = createBoolean("myExerciseComplete");

    public final StringPath myExerciseCount = createString("myExerciseCount");

    public final StringPath myExerciseDate = createString("myExerciseDate");

    public final NumberPath<Long> myExerciseId = createNumber("myExerciseId", Long.class);

    public final StringPath myExerciseSet = createString("myExerciseSet");

    public final StringPath myExerciseTime = createString("myExerciseTime");

    public QMyExercise(String variable) {
        this(MyExercise.class, forVariable(variable), INITS);
    }

    public QMyExercise(Path<? extends MyExercise> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyExercise(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyExercise(PathMetadata metadata, PathInits inits) {
        this(MyExercise.class, metadata, inits);
    }

    public QMyExercise(Class<? extends MyExercise> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.exerciseId = inits.isInitialized("exerciseId") ? new QExercise(forProperty("exerciseId"), inits.get("exerciseId")) : null;
        this.gymMemberId = inits.isInitialized("gymMemberId") ? new QGymMember(forProperty("gymMemberId")) : null;
        this.myChallengeId = inits.isInitialized("myChallengeId") ? new QMyChallenge(forProperty("myChallengeId"), inits.get("myChallengeId")) : null;
    }

}

