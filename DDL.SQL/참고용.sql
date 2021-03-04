CREATE SEQUENCE MENU_MA_SEQ;
DROP SEQUENCE MENU_MA_SEQ;
ALTER TABLE MENU_MA MODIFY(MENU_INTRO VARCHAR2(1000));
DELETE FROM MENU_MA;
SELECT * FROM MENU_MA order by menu_no;


SELECT COUNT(1), MENU_NM FROM MENU_MA GROUP BY MENU_NM;
SELECT * FROM MENU_MA WHERE MENU_NM LIKE '더블 샷% 에스프레소';

UPDATE MENU_MA
SET
MENU_NM = '더블 샷 딸기 에스프레소',
MENU_INTRO = '딸기(이)가 들어간 더블 샷 에스프레소 입니다.'
WHERE
MENU_NO = 8;

CREATE SEQUENCE FURN_MA_SEQ;
ALTER TABLE FURN_MA MODIFY(FURN_HOME VARCHAR2(100));

create sequence sto_ma_seq;
drop sequence sto_ma_seq;
delete from sto_ma;
alter table sto_ma modify(sto_grd varchar2(100));

select * from sto_ma;