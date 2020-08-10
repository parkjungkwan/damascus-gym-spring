package com.chatbot.web.passenger;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPassenger is a Querydsl query type for Passenger
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPassenger extends EntityPathBase<Passenger> {

    private static final long serialVersionUID = 1571148960L;

    public static final QPassenger passenger = new QPassenger("passenger");

    public final StringPath age = createString("age");

    public final StringPath cabin = createString("cabin");

    public final StringPath embarked = createString("embarked");

    public final StringPath fare = createString("fare");

    public final StringPath gender = createString("gender");

    public final StringPath name = createString("name");

    public final StringPath parch = createString("parch");

    public final NumberPath<Integer> passengerId = createNumber("passengerId", Integer.class);

    public final NumberPath<Integer> pclass = createNumber("pclass", Integer.class);

    public final StringPath sibSp = createString("sibSp");

    public final NumberPath<Integer> survived = createNumber("survived", Integer.class);

    public final StringPath ticket = createString("ticket");

    public QPassenger(String variable) {
        super(Passenger.class, forVariable(variable));
    }

    public QPassenger(Path<? extends Passenger> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPassenger(PathMetadata metadata) {
        super(Passenger.class, metadata);
    }

}

