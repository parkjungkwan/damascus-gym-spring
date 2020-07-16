CREATE TABLE member
(
    `member_id`              INT            NOT NULL    AUTO_INCREMENT,
    `email`                  VARCHAR(20)    NULL,
    `nickname`               VARCHAR(20)    NULL,
    `password`               VARCHAR(10)    NULL,
    `phone`                  VARCHAR(15)    NULL,
    `name`                   VARCHAR(20)    NULL,
    `ssn`                    VARCHAR(10)    NULL,
    `gender`                 VARCHAR(1)     NULL,
    `join_date`              DATETIME       NULL,
    `join_way`               VARCHAR(20)    NULL,
    `withdrawal`             DATETIME       NULL,
    `admin`                  INT            NULL,
    `volunteer_score`        INT            NULL,
    `volunteer_score_count`  INT            NULL,
    `request_score`          INT            NULL,
    `request_score_count`    INT            NULL,
    `point`                  INT            NULL,
    PRIMARY KEY (member_id)
)default character set utf8 collate UTF8_GENERAL_CI;;
CREATE TABLE article
(
    `work_id`         INT             NOT NULL    AUTO_INCREMENT,
    `title`           VARCHAR(50)     NULL,
    `write_date`      DATETIME        NULL,
    `recruit`         VARCHAR(100)    NULL,
    `work_day`        VARCHAR(10)     NULL,
    `work_time`       VARCHAR(10)     NULL,
    `work_age`        VARCHAR(3)      NULL,
    `city_area`       VARCHAR(20)     NULL,
    `day_salary`      INT             NULL,
    `total_salary`    INT             NULL,
    `contents`        VARCHAR(200)    NULL,
    `write_data_day`  INT             NULL,
    `kakao`           VARCHAR(50)     NULL,
    `progress_state`  VARCHAR(10)     NULL,
    PRIMARY KEY (work_id)
)default character set utf8 collate UTF8_GENERAL_CI;;
CREATE TABLE volunteer
(
    `volunteer_id`              INT        NOT NULL    AUTO_INCREMENT,
    `member_id`                 INT(20)    NULL,
    `work_id`                   INT(20)    NULL,
    `volunteer_date`            DATETIME   NULL,
    PRIMARY KEY (volunteer_id)
)default character set utf8 collate UTF8_GENERAL_CI;;
CREATE TABLE progress
(
    `progress_id`              INT        NOT NULL    AUTO_INCREMENT,
    `work_id`                  INT(20)    NULL,
    `volunteer_id`             INT(20)    NULL,
    `finish_date`              INT(10)    NULL,
    PRIMARY KEY (progress_id)
)default character set utf8 collate UTF8_GENERAL_CI;;