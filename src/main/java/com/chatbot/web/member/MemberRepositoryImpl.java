package com.chatbot.web.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
interface MemberRepository extends JpaRepository<Member, Long>, MemberService {}

interface MemberService {
    public List<Object> findAllOrderByJoinDate();
}
public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberService{

    MemberRepositoryImpl() {
        super(Member.class);
    }
    @Autowired JPAQueryFactory query;
    @Override
    public List<Object> findAllOrderByJoinDate() {
        QMember qMember = QMember.member;
        List<Object> result = new ArrayList<>();
        query.from(qMember)
                .orderBy(qMember.joinDate.asc())
                .fetch().forEach(arr -> {
                    result.add(arr);
        });
        return result;
    }
}
