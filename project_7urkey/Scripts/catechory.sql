

  CREATE TABLE "HR"."CATECHORY" 
   (	"CATECHORY_DIV_ID" NUMBER, 
	"CATECHORY_DIV_NAME" VARCHAR2(50 BYTE), 
	 PRIMARY KEY ("CATECHORY_DIV_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

  
insert into catechory values(1,'스킨케어');
insert into catechory values(2,'클렌징');
insert into catechory values(3,'마스크팩');
insert into catechory values(4,'선케어');
insert into catechory values(5,'베이스메이크업');
insert into catechory values(6,'아이메이크업');
insert into catechory values(7,'립메이크업');
insert into catechory values(8,'바디');
insert into catechory values(9,'헤어');
insert into catechory values(10,'향수');
insert into catechory values(99,'기타');

commit;


  CREATE TABLE "HR"."CATECHORY2" 
   (	"CATECHORY_DIV_ID2" NUMBER, 
	"CATECHORY_DIV_NAME2" VARCHAR2(50 BYTE), 
	"CATECHORY_DIV_ID" NUMBER, 
	 PRIMARY KEY ("CATECHORY_DIV_ID2")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK_CATECHORY" FOREIGN KEY ("CATECHORY_DIV_ID")
	  REFERENCES "HR"."CATECHORY" ("CATECHORY_DIV_ID") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

  
insert into catechory2 values(1,'로션',1);
insert into catechory2 values(2,'페이스오일 ',1);
insert into catechory2 values(3,'아이케어',1);
insert into catechory2 values(4,'젤',1);
insert into catechory2 values(5,'스킨',1);
insert into catechory2 values(6,'에센스',1);
insert into catechory2 values(7,'크림',1);
insert into catechory2 values(8,'미스트',1);
insert into catechory2 values(9,'클렌징워터',2);
insert into catechory2 values(10,'클렌징오일',2);
insert into catechory2 values(11,'클렌징비누',2);
insert into catechory2 values(12,'립&아이 클렌징',2);
insert into catechory2 values(13,'클렌징폼',2);
insert into catechory2 values(14,'클린징 젤',2);
insert into catechory2 values(15,'클렌징 로션',2);
insert into catechory2 values(16,'클렌징티슈',2);
insert into catechory2 values(17,'스크럽',2);
insert into catechory2 values(18,'부분마스크팩',3);
insert into catechory2 values(19,'필오프팩',3);
insert into catechory2 values(20,'패치',3);
insert into catechory2 values(21,'시트마스크',3);
insert into catechory2 values(22,'워시오프팩',3);
insert into catechory2 values(23,'슬리핑팩',3);
insert into catechory2 values(24,'코팩',3);
insert into catechory2 values(25,'선스프레이',4);
insert into catechory2 values(26,'선스틱',4);
insert into catechory2 values(27,'선크림',4);
insert into catechory2 values(28,'선케어',4);
insert into catechory2 values(29,'선쿠션',4);
insert into catechory2 values(30,'프라이머',5);
insert into catechory2 values(31,'파운데이션',5);
insert into catechory2 values(32,'파우더',5);
insert into catechory2 values(33,'블러셔',5);
insert into catechory2 values(34,'메이크업픽서',5);
insert into catechory2 values(35,'톤업크림',5);
insert into catechory2 values(36,'메이크업베이스',5);
insert into catechory2 values(37,'BB크림',5);
insert into catechory2 values(38,'쿠션',5);
insert into catechory2 values(39,'컨실러',5);
insert into catechory2 values(40,'하이라이터',5);
insert into catechory2 values(41,'세이딩',5);
insert into catechory2 values(42,'아이라이너',6);
insert into catechory2 values(43,'마스카라',6);
insert into catechory2 values(44,'아이섀도',6);
insert into catechory2 values(45,'아이브로우',6);
insert into catechory2 values(46,'속눈썹영양제',6);
insert into catechory2 values(47,'립틴트',7);
insert into catechory2 values(48,'립케어',7);
insert into catechory2 values(49,'립스틱',7);
insert into catechory2 values(50,'립글로스',7);
insert into catechory2 values(51,'바디로션',8);
insert into catechory2 values(52,'바디오일',8);
insert into catechory2 values(53,'바디미스트',8);
insert into catechory2 values(54,'여성청결제',8);
insert into catechory2 values(55,'바디기타',8);
insert into catechory2 values(56,'바디워시',8);
insert into catechory2 values(57,'바디크림',8);
insert into catechory2 values(58,'린스',9);
insert into catechory2 values(59,'헤어미스트',9);
insert into catechory2 values(60,'샴푸',9);
insert into catechory2 values(61,'헤어에센스',9);
insert into catechory2 values(62,'여성향수',10);
insert into catechory2 values(63,'남성향수',10);
insert into catechory2 values(64,'기타',99);

commit;