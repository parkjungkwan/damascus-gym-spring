package com.chatbot.web.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

interface IArticleRepository{}

@Repository
public class ArticleRepositoryImpl implements IArticleRepository {

}
