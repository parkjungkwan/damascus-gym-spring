package com.chatbot.web.passenger;

import com.chatbot.web.employment.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;
/*
0-PassengerId, 1-Survived,2-Pclass,3-Name,4-Gender,
5-Age,6-SibSp, 7-Parch, 8-Ticket, 9-Fare,
10-Cabin, 11-Embarked
* */

public interface PassengerRepository extends JpaRepository<Passenger, Integer>, IPassengerRepository{
    /* 1. 공통 인터페이스 구현은 JpaService 통해 구함
     save(S), findOne(ID), exists(ID), count, delete(T)*/

    /* 2. QueryMethod 기능
    And, Or, Is.Equals, Between, LessThan, GreaterThan, GreaterThanEqual,
    After, Before, IsNull, IsNotNull, Like, NotLike, StartingWith,
    EndingWith, Containing, OrderBy, NotIn, TRUE, FALSE, IgnoreCore* */

    List<Passenger> findBySurvived(int survived);
    Passenger findByPassengerId(int passengerId);

    /* 3. Named Query 구현 */
    List<Passenger> selectByPclass(@Param("pclass") String pclass);

    /* 4. Anonoymous Named Query 구현*/
    @Query("select e from Passenger e")
    Stream<Passenger> selectAllStream();

    // @Async CompletableFuture<Passenger> selectByName(String name);

    List<Passenger> findByEmbarked(String embarked);

    @Query(value = "SELECT * FROM Passenger WHERE age = :age", nativeQuery = true)
    List<Passenger> selectByPassenger(@Param("age")String age);

    @Query("select e from #{#entityName} e where e.cabin = :cabin or e.embarked = :embarked")
    List<Passenger> selectByCabinAndEmbarked(@Param("cabin") String cabin,
                                @Param("embarked") String embarked);
    @Modifying
    @Query("update Passenger e set e.name = :name where e.age = :age")
    int updateAgeForNameFromPassenger(@Param("name") String name,
                                      @Param("age") String age);

    void deleteByPassengerId(String passengerId);

    @Modifying
    @Query("delete from Passenger e where e.passengerId = :passengerId")
    void deletePassenger(@Param("passengerId")String passengerId);

    @Query("select e from Passenger e")
    List<Passenger> selectAllPassenger();
    /*
    querydsl 구현은 IPassengerRepository 통함
    * */

}