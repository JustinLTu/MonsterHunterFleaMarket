create sequence USERID_SEQ start with 1;
drop table USER_ACCOUNTS;
CREATE TABLE USER_ACCOUNTS
(
    USERID INT NOT NULL,
    USERNAME VARCHAR(40) NOT NULL UNIQUE,
    PASSWORD VARCHAR(40) NOT NULL,
    HUNTER_NAME VARCHAR(40) NOT NULL,
    RANK INT NOT NULL,
    EMAIL VARCHAR(40) NOT NULL,
    CONSTRAINT PK_USER_ID PRIMARY KEY (USERID)
);