package com.chatbot.web.coach;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDiary is a Querydsl query type for Diary
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDiary extends EntityPathBase<Diary> {

    private static final long serialVersionUID = -491301943L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDiary diary = new QDiary("diary");

    public final StringPath diaryComment = createString("diaryComment");

    public final StringPath diaryDate = createString("diaryDate");

    public final StringPath diaryDays = createString("diaryDays");

    public final StringPath diaryFat = createString("diaryFat");

    public final StringPath diaryGoal = createString("diaryGoal");

    public final NumberPath<Long> diaryId = createNumber("diaryId", Long.class);

    public final StringPath diaryMuscle = createString("diaryMuscle");

    public final StringPath diaryPhoto = createString("diaryPhoto");

    public final StringPath diarySkeletal = createString("diarySkeletal");

    public final StringPath diaryWater = createString("diaryWater");

    public final QGymMember gymMemberId;

    public QDiary(String variable) {
        this(Diary.class, forVariable(variable), INITS);
    }

    public QDiary(Path<? extends Diary> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDiary(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDiary(PathMetadata metadata, PathInits inits) {
        this(Diary.class, metadata, inits);
    }

    public QDiary(Class<? extends Diary> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gymMemberId = inits.isInitialized("gymMemberId") ? new QGymMember(forProperty("gymMemberId")) : null;
    }

}

