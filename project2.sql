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

create sequence TRADEID_SEQ start with 1;

CREATE TABLE TRADES
(
    TRADEID INT NOT NULL,
    IS_OFFER BOOLEAN NOT NULL,
    ITEM_NAME VARCHAR(40) NOT NULL,
    ITEM_QUANTITY INT NOT NULL,
    MESSAGE VARCHAR(300) NOT NULL,
    CONSTRAINT PK_TRADE_ID PRIMARY KEY (TRADEID)
);

CREATE TABLE USER_TRADES
(
    USERTRADEID INT,
    USERID INT REFERENCES USER_ACCOUNTS(USERID),
    TRADEID INT REFERENCES TRADES(TRADEID),
    PRIMARY KEY(USERID, TRADEID)
    
);

CREATE SEQUENCE BIDSID_SEQ START WITH 1;

CREATE TABLE BIDS
(
    BIDSID INT NOT NULL,
    ITEM_NAME VARCHAR(40) NOT NULL,
    ITEM_QUANTITY INT NOT NULL,
    PRIMARY KEY (BIDSID)
);

CREATE TABLE TRADE_BIDS
(
    TRADEID INT REFERENCES TRADES(TRADEID),
    BIDSID INT REFERENCES BIDS(BIDSID),
    PRIMARY KEY (TRADEID, BIDSID)    
);


create sequence USERTRADEID_SEQ start with 1;
select * from TRADES;
select * from USER_TRADES;
select * from USER_ACCOUNTS;
DROP TABLE USER_TRADES;