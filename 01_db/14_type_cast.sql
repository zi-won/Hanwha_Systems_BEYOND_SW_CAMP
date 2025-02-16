-- type casting
-- 명시적 형변환

-- 1) 숫자 -> 숫자
-- 부호없는 정수형으로 바꿈으로써 소수점 이하를 제거할 수도 있다.
SELECT CAST(AVG(menu_price) AS UNSIGNED INTEGER) AS '가격평균'
  FROM tbl_menu
 GROUP BY category_code;
  
DESC tbl_menu;

-- SELECT convert(AVG(menu_price), double) AS '가격평균'
SELECT CAST(AVG(menu_price) AS double) AS '가격평균'
  FROM tbl_menu
 GROUP BY category_code;
 
-- 2) 문자 -> 날짜
SELECT CAST('2025#01#07' AS DATE);
SELECT CAST('2025/01/07' AS DATE);
SELECT CAST('2025?01?07' AS DATE);

-- 3) 숫자 -> 문자
SELECT CAST(1000 AS CHAR);

SELECT CONCAT(CAST(1000 AS CHAR), '원');

SELECT Concat(1000, '원');

-- 암시적 형변환
SELECT 1 + '2';
SELECT 5 > '반가워';








