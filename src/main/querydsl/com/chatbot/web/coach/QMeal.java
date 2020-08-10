package com.chatbot.web.coach;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMeal is a Querydsl query type for Meal
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMeal extends EntityPathBase<Meal> {

    private static final long serialVersionUID = 1785531133L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMeal meal = new QMeal("meal");

    public final QFood foodId;

    public final StringPath mealCal = createString("mealCal");

    public final StringPath mealDate = createString("mealDate");

    public final NumberPath<Long> mealId = createNumber("mealId", Long.class);

    public final StringPath mealTime = createString("mealTime");

    public final QMember memberId;

    public QMeal(String variable) {
        this(Meal.class, forVariable(variable), INITS);
    }

    public QMeal(Path<? extends Meal> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMeal(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMeal(PathMetadata metadata, PathInits inits) {
        this(Meal.class, metadata, inits);
    }

    public QMeal(Class<? extends Meal> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodId = inits.isInitialized("foodId") ? new QFood(forProperty("foodId")) : null;
        this.memberId = inits.isInitialized("memberId") ? new QMember(forProperty("memberId")) : null;
    }

}

