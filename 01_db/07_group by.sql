-- group by 절
-- 메뉴가 존재하는 카테고리 그룹 조회
-- 그룹 함수(sum, avg, count, max, min)를 적용하기 위한 설정
SELECT
		 category_code		-- 그룹의 갯수만큼 select가 일어남
  FROM tbl_menu
 GROUP BY category_code;
 
-- count 함수 활용
SELECT
		 COUNT(*)			-- 해당되는 그룹의 행의 갯수를 세어준다.
	  , category_code
  FROM tbl_menu
  GROUP BY category_code;
  
-- count 함수
-- count(컬럼명 또는 *)
-- count(컬럼명): 해당 컬럼에 null이 없는 행의 갯수
-- count(*): 모든 행의 갯수

SELECT
		 COUNT(*)
	  , COUNT(ref_category_code)
  FROM tbl_category;
  
-- sum 함수 활용
SELECT
		 category_code
	  , SUM(menu_price)
  FROM tbl_menu
 GROUP BY category_code;  
  
-- group by에서 사용된 컬럼 외에 다른 컬럼은 select절에 작성하지 말자(의미 x)
-- group by 절에서 사용된 컬럼 + group 함수만 select절에 작성할 것

-- avg 함수 활용
-- round: 반올림, ceil: 올림, floor: 버림
SELECT
		 category_code
	  , floor(AVG(menu_price))
  FROM tbl_menu
 GROUP BY category_code;  
  
-- -------------------------------------------------------------------------
-- having 절
-- group에 대한 조건을 작성하는 절
SELECT
		 SUM(menu_price)
	  , category_code
  FROM tbl_menu
 GROUP BY category_code
-- HAVING category_code BETWEEN 5 AND 9;
HAVING SUM(menu_price) >= 20000;

-- ---------------------------------------------------------------------------
-- 6가지 절 모두 활용하기
SELECT
		 category_code
	  , AVG(menu_price)
  FROM tbl_menu
 WHERE menu_price > 10000
 GROUP BY category_code
HAVING AVG(menu_price) > 12000
 ORDER BY 1 DESC;
 
-- -----------------------------------------------------------------------------
-- rollup
-- group을 묶을 때 하나의 기준(하나의 컬럼)으로 그룹화하여 rollup을 하면 총 합계의 개념이 나온다.
SELECT
		 SUM(menu_price)
	  , category_code
  FROM tbl_menu
 GROUP BY category_code
  WITH ROLLUP;

-- group을 묶을 때 두 개 이상의 기준(컬럼들)으로 그룹화하여 rollup
SELECT
		 SUM(menu_price)
	  , menu_price
	  , category_code
  FROM tbl_menu
 GROUP BY menu_price, category_code
  WITH ROLLUP;  
  