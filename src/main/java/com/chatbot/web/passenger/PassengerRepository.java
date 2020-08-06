package com.chatbot.web.passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

// PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,
// Parch,Ticket,Fare,Cabin,Embarked
public interface PassengerRepository extends JpaRepository<Passenger, Integer>, IPassengerRepository{
    /* 공통 인터페이스 기능
     save(S), findOne(ID), exists(ID), count, delete(T)*/

    /* QueryMethod 기능
    And, Or, Is.Equals, Between, LessThan, GreaterThan, GreaterThanEqual,
    After, Before, IsNull, IsNotNull, Like, NotLike, StartingWith,
    EndingWith, Containing, OrderBy, NotIn, TRUE, FALSE, IgnoreCore* */

    List<Passenger> findBySurvived(int survived);
    Passenger findByPassengerId(int passengerId);

    /* Named Query 구현 */
    List<Passenger> findByPclass(@Param("pclass") String pclass);

    /* Anonoymous Named Query 구현*/
    @Query("select e from Passenger e")
    Stream<Passenger> findAllStream();

    @Async CompletableFuture<Passenger> findByName(String name);

    List<Passenger> findByEmbarked(String embarked);

    @Query(value = "SELECT * FROM Passenger WHERE age = :age", nativeQuery = true)
    List<Passenger> findByPassenger(@Param("age")String age);

    @Query("select e from #{#entityName} e where e.name = :name1 or e.name = :name2")
    List<Passenger> findByNames(@Param("name1") String name1,
                                @Param("name2") String name2);
    @Modifying
    @Query("update Passenger e set e.name = :name where e.age = :age")
    int updateAgeForNameFromPassenger(@Param("name") String name,
                                      @Param("age") String age);

    void deleteByPassengerId(String passengerId);

    @Modifying
    @Query("delete from Passenger e where e.passengerId = :passengerId")
    void deletePassenger(@Param("passengerId")String passengerId);

    @Query("select e from Passenger e")
    List<Passenger> findAllPassenger();

}