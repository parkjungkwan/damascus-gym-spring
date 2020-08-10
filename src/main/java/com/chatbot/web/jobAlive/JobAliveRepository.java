package com.chatbot.web.jobAlive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

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

   /* @Query("SELECT itv.interviewer_id AS interviewerId, itv.name AS name, itv.phone AS phone "
            + "FROM Awaiter a JOIN a.interviewer itv JOIN a.alive live  "
            + "WHERE live.liveSeq = ?1")  */
    List<Map<String,Object>> findAwaiterList(Long liveSeq);


}
interface CorporationRepository extends JpaRepository<Corporation, Long>, ICorporationRepository{}
interface InterviewerRepository extends JpaRepository<Interviewer, Long>, IInterviewerRepository{}
interface JobNoticeRepository extends JpaRepository<JobNotice, Long>, IJobNoticeRepository{}
interface JobScraptRepository extends JpaRepository<JobScrap, Long>, IJobScrapRepository {}
interface PublicRelationRepository extends JpaRepository<PublicRelation, Long>, IPublicRelationRepository{}
