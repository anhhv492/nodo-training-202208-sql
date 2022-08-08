--4.1 Liệt kê tên nhân viên, mã phòng ban và lương nhân viên được tăng 15% (PCTSAL).
SELECT ENAME,DEPTNO,NVL((SAL+ SAL*0.15),0) AS PCTSAL FROM EMP;

--4.2 Viết câu lệnh hiển thị như sau:
SELECT CONCAT( RPAD(ENAME,3,'*'), LPAD(JOB,20,'*'))AS EMPLOYEE_AND_JOB  FROM EMP;

--4.3 Viết câu lệnh hiển thị như sau:
SELECT CONCAT(ENAME,(' ('||EMP.JOB||')')) FROM EMP;

--4.4 Viết câu lệnh hiển thị như sau:
SELECT ENAME,DEPTNO, REPLACE(JOB,'SALEMAN','Salesperson') FROM EMP WHERE DEPTNO=30;

--4.5 Tìm ngày thứ 6 đầu tiên cách 2 tháng so với ngày hiện tại hiển thị ngày dưới dạng 09 February 1990.
SELECT HIREDATE,TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE,2),'FRIDAY'),'dd month yyyy') FROM EMP;

--4.6 Tìm thông itn về tên nhân viên, ngày gia nhập công ty của nhân viên phòng số 20, sao cho hiển thị như sau:
SELECT ENAME, TO_CHAR (HIREDATE, 'month')||','||TO_CHAR(HIREDATE,'DAY') FROM EMP
                                                                        WHERE DEPTNO=20 AND HIREDATE IS NOT NULL ;

--4.7 Hiển thị tên nhân viên, ngày gia nhập công ty, ngày xét nâng lương (sau ngày gia
-- nhập công ty 1 năm), sắp xếp theo thứ tự ngày xét nâng lương.
SELECT ENAME, HIREDATE,ADD_MONTHS(HIREDATE,12)AS REVIEW FROM EMP WHERE HIREDATE IS NOT NULL ORDER BY REVIEW ASC;

--4.8 Hiển thị tên nhân viên và lương dưới dạng
SELECT ENAME,SAL,(CASE
    WHEN SAL<1500 THEN ('BELOW 1500')
    ELSE TO_CHAR(SAL)
    END)AS SALS FROM EMP WHERE SAL IS NOT NULL ;
--4.9 Cho biết thứ của ngày hin tại
SELECT TO_CHAR(SYSDATE, 'DAY') AS DAY,TO_CHAR(SYSDATE, 'dd/mm/yyyy') AS NOW FROM EMP
                                                                            GROUP BY TO_CHAR(SYSDATE, 'DAY');

--4.10 Đưa chuỗi dưới dạng nn/nn, kiểm tra nếu khúng khuôn dạng trả lời là YES, ngược lại là NO.
-- Kiểm tra với các chuỗi 12/34, 01/1a, 99\88
select decode('12/34', '12/34', 'YES', '01/1a', 'NO', '99\98', 'NO', 'NOT') decode_check
from DUAL;

--4.11 Hiển thị tên nhân viên, ngày gia nhập công ty, ngày lĩnh lương sao cho ngày lĩnh lương phải vào thứ 6,
-- nhân viên chỉ được nhận lương sau ít nhất 15 ngày làm việc tại công ty, sắp xếp theo thứ tự ngày gia nhập công ty.
SELECT ENAME, HIREDATE,NEXT_DAY(HIREDATE+INTERVAL '15' DAY,'FRIDAY'),TO_CHAR(NEXT_DAY(HIREDATE+ 15,'FRIDAY'),'DAY')
FROM EMP WHERE HIREDATE IS NOT NULL
         ORDER BY HIREDATE DESC ;

-- 1 Tìm lương thấp nhất, lớn nhất và lương trung bình của tất cả các nhân viên
SELECT MIN(SAL),MAX(SAL),AVG(SAL) FROM EMP;

-- 2 Tìm lương nhỏ nhất và lớn của mỗi loại nghề nghiệp
SELECT MIN(SAL),JOB FROM EMP WHERE SAL IS NOT NULL GROUP BY JOB ;

-- 3 Tìm xem có bao nhiêu giám đốc trong danh sách nhân viên.
SELECT COUNT(JOB) FROM EMP WHERE JOB LIKE 'MANAGER';

-- 4 Tìm tất cả các phòng ban mà số nhân viên trong phòng >3
SELECT COUNT(ENAME),JOB FROM EMP GROUP BY JOB HAVING COUNT(ENAME) >3;

-- 5 Tìm ra mức lương nhỏ nhất của mỗi nhân viên làm việc cho một giám đốc nào đó
-- sắp xếp theo thứ tự tăng dần của mức lương
SELECT ENAME,NVL(SAL,0) FROM EMP WHERE JOB != 'MANAGER'
                                 ORDER BY SAL ASC;

--5.1. Hiển thị toàn bộ tên nhân viên và tên phòng ban làm việc sắp xếp theo tên phòng ban.
SELECT ENAME,DNAME FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO
                   ORDER BY DNAME;

--5.2 Hiển thị tên nhân viên, vị trí địa lý, tên phòng với điều kiện lương >1500.
SELECT ENAME,LOC,DNAME FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO
                       WHERE EMP.SAL>1500 ORDER BY DNAME;

--5.3 Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương.
SELECT (CASE
    WHEN SAL<1250 THEN '1'
    WHEN SAL<1600 THEN '2'
    WHEN SAL<2850 THEN '3'
    WHEN SAL<5000 THEN '4'
    ELSE '5' END) GRADE,ENAME,JOB,SAL FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO WHERE SAL IS NOT NULL ;
--5.4 Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương, với điều kiện mức lương=3.
SELECT ENAME,JOB,NVL(SAL,0),(CASE WHEN SAL BETWEEN 1250 AND 1600 THEN '3' END) GRADE
FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO WHERE (CASE WHEN SAL BETWEEN 1250 AND 1600 THEN '3' END) = '3';

--5.5. Hiển thị những nhân viên tại DALLAS
SELECT ENAME,LOC,NVL(SAL,0) AS SAL FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO
                 WHERE LOC = 'DALLAS';
--5.6 Hiển thị tên nhân viên , nghề nghiệp, lương, mức lương, tên phòng làm việc trừ nhân
-- viên có nghề là cleck và sắp xếp theo chiều giảm
SELECT ENAME,JOB, SAL,(CASE WHEN SAL<(SELECT LOSAL FROM SALGRADE WHERE GRADE=1) THEN '1'
                                 WHEN SAL<(SELECT LOSAL FROM SALGRADE WHERE GRADE=2) THEN '2'
                                 WHEN SAL<(SELECT LOSAL FROM SALGRADE WHERE GRADE=3) THEN '3'
                                 WHEN SAL<(SELECT LOSAL FROM SALGRADE WHERE GRADE=4) THEN '4'
                                 ELSE '5' END) GRADE,DNAME FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO
                                   WHERE JOB != 'CLERK' AND SAL IS NOT NULL ORDER BY GRADE DESC;
--5.7 Hiển thị chi tiết về những nhân viên kiếm được 36000 $ 1 năm hoặc nghề là cleck.
-- (gồm các trường tên, nghề, thu nhập, mã phòng, tên phòng, mức lương)
SELECT ENAME,JOB,SAL,DEPT.DEPTNO,DNAME,(CASE WHEN SAL<(SELECT LOSAL FROM SALGRADE WHERE GRADE=1) THEN '1'
                                             WHEN SAL<(SELECT LOSAL FROM SALGRADE WHERE GRADE=2) THEN '2'
                                             WHEN SAL<(SELECT LOSAL FROM SALGRADE WHERE GRADE=3) THEN '3'
                                             WHEN SAL<(SELECT LOSAL FROM SALGRADE WHERE GRADE=4) THEN '4'
                                             ELSE '5' END) GRADE FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO
                                                                 WHERE NVL(SAL*12,0)>=36000
                                                                 ORDER BY GRADE ASC;

--5.8 Hiển thị những phòng không có nhân viên nào làm việc.
SELECT DEPTNO FROM DEPT WHERE DEPTNO NOT IN
                              (SELECT EMP.DEPTNO FROM EMP WHERE EMP.DEPTNO IS NOT NULL GROUP BY DEPTNO  ) ;

-- 5.9. Hiển thị mã nhân viên, tên nhân viên, mã người quản lý, tên người quản lý
---------SELECT EMPNO,ENAME EMP_NAME, (SELECT EMPNO FROM EMP WHERE JOB = 'MANAGER') MGR_NAME FROM EMP;
SELECT E1.ENAME AS EMP_NAME,NVL(E1.SAL,0) AS EMP_SAL, E2.ENAME AS MGR_NAME, NVL(E2.SAL,0) MGR_SAL
FROM EMP E1, EMP E2 WHERE E1.MGR=E2.EMPNO ORDER BY MGR_SAL DESC;
---5.10 Như câu 9 hiển thị thêm thông tin về ông KING.
SELECT E1.ENAME AS EMP_NAME,NVL(E1.SAL,0) AS EMP_SAL, E2.ENAME AS MGR_NAME, NVL(E2.SAL,0) MGR_SAL
FROM EMP E1, EMP E2 WHERE E1.MGR=E2.EMPNO ORDER BY EMP_SAL DESC;
--5.11 Hiển thị nghề nghiệp được tuyển dụng vào năm 1981 và không được tuyển dụng vào năm 1994
SELECT JOB, TO_CHAR(HIREDATE,'YYYY') FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY')='1981'
                                                AND TO_CHAR(HIREDATE,'YYYY')!='1994';

--5.14 Tìm những nhân viên kiếm được lương cao nhất trong mỗi loại nghề nghiệp.
SELECT EMPNO,ENAME,JOB,SAL FROM EMP
                           WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY JOB) ORDER BY SAL DESC ;

--5.17 Hiển thị những nhân viên có mức lương lớn hơn lương TB của phòng ban mà họ làm
SELECT EMPNO,ENAME,JOB,SAL FROM EMP
WHERE SAL IN (SELECT AVG(SAL) FROM EMP GROUP BY JOB) ORDER BY SAL DESC ;
