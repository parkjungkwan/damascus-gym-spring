package com.chatbot.web.passenger;

import static com.chatbot.web.passenger.QPassenger.passenger;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.DerbyTemplates;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.jpa.JPAExpressions;
import static com.querydsl.core.types.ExpressionUtils.count;
/*
0-PassengerId, 1-Survived,2-Pclass,3-Name,4-Gender,
5-Age,6-SibSp, 7-Parch, 8-Ticket, 9-Fare,
10-Cabin, 11-Embarked
* */
interface IPassengerRepository{
/*
querydsl category
1- JPAQuery : EntityManager 담당, JPQL 사용
2- JPAQueryFactory : EntityManager 담당, JPQL 사용
3- JPASQLQuery : EntityManager 담당, SQL 사용
4- SQLQuery : JDBC 담당, SQL 사용
5- SQLQueryFactory : JDBC 담당, SQL 사용
6- JPAUpdateClause : 배치프로그램(수정)
* */

    List<Passenger> fetchByName(String name); // 1- JPAQuery
    List<Passenger> fetchByGenderAndGreaterThanAge(String gender, String age); // 1- JPAQuery
    List<Passenger> fetchBySurvived(String survived); // 2- JPAQueryFactory
    List<PassengerCounter> countPassengersByAgeAndEmbarked(String gender, String embarked); // 2- JPAQueryFactory
    List<Passenger> fetchByPclass(String pclass); // 3- JPASQLQuery
    List<Passenger> fetchByGender(String gender); // 5- SQLQueryFactory
    Long updateAge(String passengerId, String age);
}

@Repository public class PassengerRepositoryImpl extends QuerydslRepositorySupport implements IPassengerRepository {

    private final JPAQueryFactory queryFactory;
    private final DataSource dataSource;

    PassengerRepositoryImpl(JPAQueryFactory queryFactory, DataSource dataSource){
        super(Passenger.class);
        this.queryFactory = queryFactory;
        this.dataSource = dataSource;
    }
    @Override public List<Passenger> fetchByName(String name) {
        // 1- JPAQuery : EntityManager 담당, JPQL 사용
        return new JPAQuery<Passenger>().select(passenger)
                .from(passenger)
                .where(passenger.name.eq(""))
                .orderBy(passenger.name.desc())
                .fetch();
        // fetch 는 복수의 데이터값 리턴
    }
    @Override public List<Passenger> fetchByGenderAndGreaterThanAge(String gender, String age) {
        // 1- JPAQuery : EntityManager 담당, JPQL 사용
        return new JPAQuery<Passenger>().select(passenger)
                .from(passenger)
                .where(passenger.gender.eq(gender).and(passenger.age.gt(age)))
                .orderBy(passenger.passengerId.asc())
                .fetch();

        // where(passenger.gender.eq(gender), (passenger.age.gt(age))) 로 변경 가능
    }

    @Override public List<Passenger> fetchBySurvived(String survived) {
        // 2- JPAQueryFactory : EntityManager 담당, JPQL 사용
        return queryFactory.selectFrom(passenger)
                .where(passenger.survived.eq(1))
                .fetch();
    }

    @Override public List<PassengerCounter> countPassengersByAgeAndEmbarked(String gender, String embarked) {
        // 2- JPAQueryFactory : 항구별로 승선한 승객 중 성별에 따른 수 출력
        return queryFactory
                .select(Projections.fields(PassengerCounter.class,
                        passenger.embarked.as("embarked"),
                        passenger.gender.as("gender"),
                        ExpressionUtils.as(
                                JPAExpressions.select(count(passenger.passengerId))
                                        .from(passenger)
                                        .where(passenger.gender.eq(gender), passenger.embarked.eq(embarked)),
                                "passengerCounter")
                ))
                .from(passenger)
                .fetch();
        // ExpressionUtils은 Querydsl 내부에서 새로운 Expression을 사용할 수 있도록 지원
        // as를 통해 서브쿼리의 결과물을 alias
    }

    @PersistenceContext private EntityManager entityManager;
    @Override public List<Passenger> fetchByPclass(String pclass) {
        // 3- JPASQLQuery : EntityManager 담당, SQL 사용
        return new JPASQLQuery<>(entityManager, new DerbyTemplates())
                .select(passenger).from(passenger)
                .where(passenger.pclass.eq(Integer.parseInt(pclass))).fetch();
    }

    @Override public List<Passenger> fetchByGender(String gender) {
        // 5- SQLQueryFactory : JDBC 담당, SQL 사용
        return new SQLQueryFactory(new Configuration(new DerbyTemplates()), dataSource)
                .select(passenger).from(passenger)
                .where(passenger.gender.eq(gender))
                .fetch();
    }
    @Override public Long updateAge(String passengerId, String age){
        return new JPAUpdateClause(entityManager, passenger)
                .where(passenger.passengerId.eq(Integer.valueOf(passengerId)))
                .set(passenger.age, age)
                .execute();
    }

}
