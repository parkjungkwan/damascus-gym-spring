package com.chatbot.web.coach;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMyChallenge is a Querydsl query type for MyChallenge
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMyChallenge extends EntityPathBase<MyChallenge> {

    private static final long serialVersionUID = -971406435L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMyChallenge myChallenge = new QMyChallenge("myChallenge");

    public final QMember memberId;

    public final NumberPath<Long> myChallengeId = createNumber("myChallengeId", Long.class);

    public final StringPath myChallengeName = createString("myChallengeName");

    public final ListPath<MyExercise, QMyExercise> myExercises = this.<MyExercise, QMyExercise>createList("myExercises", MyExercise.class, QMyExercise.class, PathInits.DIRECT2);

    public QMyChallenge(String variable) {
        this(MyChallenge.class, forVariable(variable), INITS);
    }

    public QMyChallenge(Path<? extends MyChallenge> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMyChallenge(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMyChallenge(PathMetadata metadata, PathInits inits) {
        this(MyChallenge.class, metadata, inits);
    }

    public QMyChallenge(Class<? extends MyChallenge> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberId = inits.isInitialized("memberId") ? new QMember(forProperty("memberId")) : null;
    }

}

