package com.chatbot.web.jobInterview;

import org.springframework.data.jpa.repository.JpaRepository;

interface ManagerRepository extends JpaRepository<Manager, Long>, IManagerRepository {
    Manager findByManagerIdAndPwd(String managerId, String pwd);
}
