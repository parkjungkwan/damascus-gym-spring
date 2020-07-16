package com.chatbot.web.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
interface ArticleRepository extends JpaRepository<Article, Long>, ArticleService{}
interface ArticleService {}
public class ArticleRepositoryImpl extends QuerydslRepositorySupport implements ArticleService {

    public ArticleRepositoryImpl() {
        super(Article.class);
    }


}
