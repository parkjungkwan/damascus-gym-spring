package com.chatbot.web.jobInterview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface JobAliveRepository extends JpaRepository<JobAlive, Long>, IJobScrapRepository {
    @Modifying
    @Transactional
    @Query("UPDATE JobAlive"
            + "    SET state = ?2 "
            + "  WHERE jobAliveId = ?1")
    void updateState(Long liveSeq, String state);
}
interface ApplicantRepository extends JpaRepository<Applicant, Long>, IApplicantRepository{
    @Query("SELECT n.jobNoticeId as noticeSeq, n.title as title, n.corporName as corName, "
            + "n.startDate as startDate, n.startTime as startTime, a.appState as state "
            + "FROM Applicant a JOIN a.jobNotice n "
            + "WHERE a.itvSeq = ?1")
    List<Map<String,Object>> getNoticeList(Long itvSeq);

    @Query("select count(a) from Applicant a where a.itvSeq =?1 and a.jobNotice.jobNoticeId =?2")
    String countApply(Long itvSeq, Long noticeSeq);
}
interface AwaiterRepository extends JpaRepository<Awaiter, Long>, IAwaiterRepository{
    @Query("SELECT live.corporName AS corporName, live.startDate AS startDate, "
            + "live.startTime AS startTime, a.result AS result, live.state AS state, live.url AS url "
            + "FROM Awaiter a JOIN a.interviewer itv JOIN a.jobAlive live  "
            + "WHERE itv.interviewerId = ?1")
    List<Map<String,Object>> findAliveList(Long itvSeq);
    List<Map<String,Object>> findAwaiterList(Long liveSeq);
}
interface CorporationRepository extends JpaRepository<Corporation, Long>, ICorporationRepository{
    Optional<Corporation> findByCorId(String corId);
    Corporation findByCorIdAndPwd(String corId, String pwd);
    Long countByCorId(String corId);

    @Query("SELECT c.pmEmail FROM Corporation c WHERE c.corporCode = ?1")
    public String findPmEmailByCorId(String corId);

    @Modifying
    @Transactional
    @Query("UPDATE Corporation "
            + "    SET password = ?2 "
            + "  WHERE corporId = ?1")
    public void updatePwdByCorId(String corId, String pwd);
/*
* 벌크성 수정 쿼리: 대량의 데이터들을 쿼리를 통해 수정. 대량 처리를 했을 시에는 속도가 빠르지만 한 행 처리에 있어서는 다소 느림
* spring jpa에서는 @Modifying 어노테이션 사용으로 처리
* ?2 는 파라미터 위치값. 주의점은 1부터 시작함. 이는 JDBC 의 executeUpdate() 를 대체하는 문법을 뜻함.
* */
    @Modifying
    @Transactional
    @Query("UPDATE Corporation"
            + "    SET password = ?2, "
            + "        corporName = ?3, "
            + "        ceoName = ?4, "
            + "        area = ?5, "
            + "        pmName = ?6, "
            + "        pmPhone = ?7, "
            + "        pmEmail = ?8, "
            + "        city = ?9, "
            + "        homepage = ?10 "
            + "  WHERE corporId = ?1")
    void updateByCorId(String corporId, String password, String corporName,
                              String ceoName, String area, String pmName,
                              String pmPhone, String pmEmail, String city,
                              String homepage);
}
interface InterviewerRepository extends JpaRepository<Interviewer, Long>, IInterviewerRepository{}
interface JobNoticeRepository extends JpaRepository<JobNotice, Long>, IJobNoticeRepository{}
interface JobScraptRepository extends JpaRepository<JobScrap, Long>, IJobScrapRepository {}
interface PublicRelationRepository extends JpaRepository<PublicRelation, Long>, IPublicRelationRepository{}
