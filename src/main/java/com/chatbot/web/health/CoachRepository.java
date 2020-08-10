package com.chatbot.web.health;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import java.util.List;
import java.util.Optional;

interface ChallengeRepository extends JpaRepository<Challenge, Long> { }
interface CoachRepository extends JpaRepository<Coach, Long>{
    boolean existsByMemberId(GymMember gymMemberId);
    Coach findByMemberId(GymMember gymMemberId);
    boolean existsByCoachId(Coach coacheId);
}
interface DiaryRepository extends JpaRepository<Diary, Long> {
    boolean existsByMemberIdAndDiaryDate(GymMember gymMemberId, String diaryDate);
    Diary findByDiaryDateAndMemberId(String diaryDate, GymMember gymMemberId);
    List<Diary> findByMemberId(GymMember gymMemberId);
}
interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByChallengeId(Challenge challengeId);
    @Query(value = "select * from exercises group by exercise_name", nativeQuery = true)
    List<Exercise> findGroupByExerciseName();
}
interface FoodRepository extends JpaRepository<Food, Long> {}
interface GymRepository extends JpaRepository<Gym, Long>, QuerydslPredicateExecutor<Gym> {}
interface MealRepository extends JpaRepository<Meal, Long> {
    Iterable<Meal> findByMealDate(String mealDate);
}
interface MemberRepository extends JpaRepository<GymMember, Long> {
    Optional<GymMember> findByMemberEmailAndMemberPw(String email, String pw);
}
interface MyChallengeRepository extends JpaRepository<MyChallenge, Long>{
    List<MyChallenge> findByMemberId(GymMember gymMemberId);
    MyChallenge findFirstByOrderByMyChallengeIdDesc();
}
interface MyExerciseRepository extends JpaRepository<MyExercise, Long> {
    Iterable<MyExercise> findByMyExerciseDate(String myExerciseDate);
    List<MyExercise> findByMyChallengeId(MyChallenge myChallengeId);
}
interface ReportRepository extends JpaRepository<Report, Long>{
    Report findByReportDate(String reportDate);
    void deleteByReportDate(String reportDate);
}

