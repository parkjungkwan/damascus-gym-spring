package com.chatbot.web.progress;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRepository extends JpaRepository<Progress, Long>, IProgressRepository {
}
