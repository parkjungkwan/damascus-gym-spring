package com.chatbot.web;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QuerydslConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(entityManager);
    }
}

/*
querydsl category
1- JPAQuery : EntityManager 담당, JPQL 사용
2- JPAQueryFactory : EntityManager 담당, JPQL 사용
3- JPASQLQuery : : EntityManager 담당, SQL 사용
4- SQLQuery : JDBC 담당, SQL 사용
5- SQLQueryFactory : JDBC 담당, SQL 사용
* */
