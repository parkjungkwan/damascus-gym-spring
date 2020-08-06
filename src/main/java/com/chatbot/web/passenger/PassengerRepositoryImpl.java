package com.chatbot.web.passenger;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import java.util.List;

interface IPassengerRepository{

}
@Repository
public class PassengerRepositoryImpl extends QuerydslRepositorySupport implements IPassengerRepository {
// PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,
// Parch,Ticket,Fare,Cabin,Embarked

    private final JPAQueryFactory queryFactory;

    PassengerRepositoryImpl(JPAQueryFactory queryFactory){
        super(Passenger.class);
        this.queryFactory = queryFactory;
    }
    public List<Passenger> findByName(String name) {
        QPassenger passenger = QPassenger.passenger;
        return queryFactory
                .selectFrom(passenger)
                .where(passenger.name.eq(name))
                .fetch();
    }


}
