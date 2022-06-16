CREATE SEQUENCE REPORT_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 100000000;


DROP TABLE REPORT_FILES;
DROP TABLE REPORT;
drop sequence REPORT_SEQ;


	/** 
	 *	신고 게시글 VO
	 *	
	 *	신고 넘버 PK
	 *	신고 게시글 타입(나만의화장법, 제품리뷰, 기타등)
	 *	신고 당한 게시글 번호
	 *	신고 자(일반회원) FK
	 *	신고 제목
	 *	신고 내용
	 *	신고 날짜
	 *	신고   1 or 2 || 삭제 or 통과
	 *
	 */

CREATE TABLE REPORT(
	report_num NUMBER(10),
	report_type CHAR(1) CHECK(report_type IN('1', '2')),
	report_board NUMBER(10),
	userid VARCHAR2(50),
	report_title VARCHAR2(500),
	report_contents VARCHAR2(3000) ,
	report_date DATE,
	report_result CHAR(1) CHECK(report_result IN('1', '2')),
	CONSTRAINTS REPORT_PK PRIMARY KEY(report_num)
);


CREATE TABLE REPORT_FILES(
	REPORT_FILE_NAME VARCHAR2(100),
	REPORT_NUM,
	CONSTRAINTS REPORT_FILE_NAME_PK PRIMARY KEY(REPORT_FILE_NAME),
	CONSTRAINTS REPORT_FILE_NAME_FK FOREIGN KEY(REPORT_NUM) REFERENCES REPORT(REPORT_NUM)
);


-- report_type NUMBER(10)  ->  1_나만의화정법 ,  2_제품리뷰  


-- (테스트 ) 게시글  신고  입력
INSERT INTO REPORT
VALUES(REPORT_SEQ.NEXTVAL, 2, 1, 'aaa', '이놈 신고한다', ' 게시글 삭제해주세요', SYSDATE, 2);



SELECT * FROM REPORT;
SELECT * FROM REPORT_FILES;


SELECT 
report_num, report_type, report_board, USERID, report_title, report_date
FROM REPORT WHERE report_result = '1' ORDER BY REPORT_NUM DESC;
		
-- test
--SELECT * FROM test WHERE family_name = '김' OR salary = 20000;

UPDATE REPORT
  SET report_result = '1'
  WHERE REPORT_NUM = 1  AND MEMBER_ID = '123';

INSERT INTO REPORT
VALUES(REPORT_SEQ.NEXTVAL, '1', 1, 'aaa', '이놈 신고한다', ' 게시글 삭제해주세요', SYSDATE, '1');