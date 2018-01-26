DROP TABLE USER_INFO CASCADE CONSTRAINTS;
CREATE TABLE USER_INFO
  (
    USER_ID 		VARCHAR2 (2 BYTE) NOT NULL ,
    FIRSTNAME      	VARCHAR2 (40 BYTE) NOT NULL ,
	LASTNAME        VARCHAR2 (40 BYTE) NOT NULL ,
	DOB				TIMESTAMP(6),
	EMAIL			VARCHAR2 (40 BYTE) NOT NULL ,
	PHONE 			VARCHAR2 (20 BYTE) NOT NULL ,	
	STATUS			VARCHAR2 (20 BYTE) NOT NULL ,
    CREATED_BY      VARCHAR2 (80 BYTE) NOT NULL ,
	CREATED_TS      TIMESTAMP(6) ,
    UPDATED_TS      TIMESTAMP(6) ,
    UPDATED_BY      VARCHAR2 (80 BYTE) ,
    VERSION         NUMBER (10) DEFAULT 1 NOT NULL
  )
TABLESPACE user_01;
ALTER TABLE USER_INFO ADD CONSTRAINT PK_USER_ID PRIMARY KEY ( USER_ID ) USING INDEX TABLESPACE user_01  ENABLE;

ALTER TABLE USER_INFO RENAME TO USERS;

DROP SEQUENCE USERS_SEQ;
CREATE SEQUENCE USERS_SEQ START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER  T_USERS_SEQ_BI 
BEFORE INSERT ON USERS FOR EACH ROW
WHEN (NEW.USER_ID IS NULL) BEGIN
SELECT USERS_SEQ.NEXTVAL INTO :NEW.USER_ID FROM DUAL;
END;
/
ALTER TRIGGER T_USERS_SEQ_BI ENABLE; 

ALTER TABLE USERS MODIFY USER_ID NUMBER(10,0);