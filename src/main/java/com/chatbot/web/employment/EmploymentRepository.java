package com.chatbot.web.employment;
import org.springframework.data.jpa.repository.JpaRepository;
interface WorkMemberRepository extends JpaRepository<WorkMember, Long>, IWorkMemberRepository {
}
interface VolunteerRepository extends JpaRepository<Volunteer, Long>, IVolunteerRepository {
}
interface ProgressRepository extends JpaRepository<Progress, Long>, IProgressRepository {
}
interface WorkArticleRepository extends JpaRepository<WorkArticle, Long> {
}