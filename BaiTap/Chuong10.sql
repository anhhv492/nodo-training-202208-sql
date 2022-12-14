-- 10.1 Tạo view có hiển thị như sau:
-- select * from aggredates;
-- DEPTNO AVERAGE MAXIMUN MINIMUN SUM NO_SALS NO_COMMS
-- 10 2916.66667 5000 1300 8750 3 0
-- 20 2235 3300 800 11175 5 0
-- 30 1566.66667 2850 950 9400 6 4

SELECT * FROM EMP;
CREATE VIEW va_view_aggredates AS
SELECT EMP.DEPTNO, TO_CHAR(AVG(SAL),'999,999') AS AVERAGE,MAX(SAL)AS MAXIMUN,MIN(SAL)AS MINIMUN,
       SUM(SAL) AS SUM,COUNT(SAL) AS NO_SALS,COUNT(COMM) AS NO_COMMS
FROM DEPT JOIN EMP ON DEPT.DEPTNO = EMP.DEPTNO
GROUP BY EMP.DEPTNO;
SELECT * FROM va_view_aggredates;
-- 10.2 Tạo view để nhập số liệu vào bảng ASIGNMENT với các điều kiện sau:
-- PROJID <2000, P_START_DATE<P_END_DATE
-- Các giá trị có thể chấp nhận của assign_type là PS, WT hoặc ED
-- EMPNO có giá trị NOT NULL
-- BILL_RATE < 50 Với ASSIGN_TYPE Là PS
-- BILL_RATE < 60 Với ASSIGN_TYPE Là WT
-- BILL_RATE < 70 Với ASSIGN_TYPE Là ED
CREATE VIEW assignment_view_va AS SELECT * FROM ASSIGNMENT;
SELECT * FROM assignment_view_va ;
INSERT INTO assignment_view_va(PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_RATE, ASSIGN_TYPE, HOURS)
VALUES (3,7844,'2000-01-01','2060-10-11',40.00,'PS',15);
-- 10.3 Định nghĩa bảng MESSAGES có cấu trúc
-- Column name Data Type
-- NUMCOL1 NUMBER(9,2)
-- NUMCOL2 NUMBER(9,2)
-- CHARCOL1 VARCHAR2(60)
-- CHARCOL2 VARCHAR2(60)
-- DATECOL1 DATE
-- DATECOL2 DATE
CREATE TABLE MESSAGES
(
    NUMCOL1 NUMBER(9,2) NOT NULL ,
    NUMCOL2 NUMBER(9,2) NOT NULL ,
    CHARCOL1 VARCHAR2(60) NOT NULL ,
    CHARCOL2 VARCHAR2(60) NOT NULL ,
    DATECOL1 DATE NOT NULL ,
    DATECOL2 DATE NOT NULL 
);
