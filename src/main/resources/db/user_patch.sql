 CREATE BIGFILE TABLESPACE user_01 DATAFILE 'users.dat'   SIZE 20M   AUTOEXTEND ON;
 
 Create User EXP_USERS identified by EXP_USERS default tablespace user_01;
 
 grant all privileges to EXP_USERS;