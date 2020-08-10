package com.chatbot.web.coach;

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
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -2091148460L;

    public static final QMember member = new QMember("member1");

    public final ListPath<Coach, QCoach> coaches = this.<Coach, QCoach>createList("coaches", Coach.class, QCoach.class, PathInits.DIRECT2);

    public final ListPath<Diary, QDiary> diaries = this.<Diary, QDiary>createList("diaries", Diary.class, QDiary.class, PathInits.DIRECT2);

    public final ListPath<Meal, QMeal> meals = this.<Meal, QMeal>createList("meals", Meal.class, QMeal.class, PathInits.DIRECT2);

    public final StringPath memberEmail = createString("memberEmail");

    public final StringPath memberHeight = createString("memberHeight");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath memberName = createString("memberName");

    public final StringPath memberPhoto = createString("memberPhoto");

    public final StringPath memberPw = createString("memberPw");

    public final StringPath memberText = createString("memberText");

    public final NumberPath<Integer> memberType = createNumber("memberType", Integer.class);

    public final StringPath memberWeight = createString("memberWeight");

    public final ListPath<MyChallenge, QMyChallenge> myChallenges = this.<MyChallenge, QMyChallenge>createList("myChallenges", MyChallenge.class, QMyChallenge.class, PathInits.DIRECT2);

    public final ListPath<MyExercise, QMyExercise> myExercises = this.<MyExercise, QMyExercise>createList("myExercises", MyExercise.class, QMyExercise.class, PathInits.DIRECT2);

    public final ListPath<Report, QReport> reports = this.<Report, QReport>createList("reports", Report.class, QReport.class, PathInits.DIRECT2);

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

