package com.chatbot.web.employment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

interface IWorkMemberRepository {
    public List<Object> findAllOrderByJoinDate();
}

public class WorkMemberRepositoryImpl extends QuerydslRepositorySupport implements IWorkMemberRepository {

    WorkMemberRepositoryImpl() {
        super(WorkMember.class);
    }
    @Autowired
    JPAQueryFactory query;
    @Override
    public List<Object> findAllOrderByJoinDate() {
        /*QMember qMember = QMember.member;
        List<Object> result = new ArrayList<>();
        query.from(qMember)
                .orderBy(qMember.joinDate.asc())
                .fetch().forEach(arr -> {
            result.add(arr);
        });*/
        return null;
    }

}
