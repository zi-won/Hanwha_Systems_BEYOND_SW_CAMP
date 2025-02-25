-- join

SELECT * FROM tbl_menu;
SELECT * FROM tbl_category;

-- 별칭 미 작성 시
SELECT
		 menu_name
	  , category_name
--   , category_code				-- 이 부분은 ambiguos 에러 발생
  FROM tbl_menu
  JOIN tbl_category ON tbl_menu.category_code = tbl_category.category_code;
  
-- 별칭 작성 시
-- 테이블 또는 from 절에 별칭을 추가할 때는 mariadb는 싱글쿼테이션(')없이 별칭을 작성해야한다.(as는 생략 가능하다)
SELECT
		 a.menu_name AS '메뉴명'
	  , b.category_name
	  , b.category_code
  FROM tbl_menu a
  JOIN tbl_category b ON a.category_code = b.category_code;
  
-- ----------------------------------------------
-- inner join
SELECT
		 a.menu_name AS '메뉴명'
	  , b.category_name
	  , b.category_code
  FROM tbl_menu a
 inner JOIN tbl_category b ON a.category_code = b.category_code;


-- 2)using 활용(컬럼명이 같을 때는 using을 활용해서 짧은 구문으로 작성 가능)
SELECT
		 a.menu_name
	  , b.category_name
	  , b.category_code
  FROM tbl_menu a
 inner JOIN tbl_category b using (category_code);
 
-- ------------------------------------------------------------------
-- outer join
-- 1) left join
SELECT
		 a.category_name
	  , b.menu_name
  FROM tbl_category a
 LEFT JOIN tbl_menu b ON a.category_code = b.category_code;

-- 2) right join  
SELECT
		 b.category_name
	  , a.menu_name
  FROM tbl_menu a
 right JOIN tbl_category b ON a.category_code = b.category_code;

-- 3) cross join
SELECT
		 *
  FROM tbl_menu a
 CROSS JOIN tbl_category b;

-- 4) self join
SELECT
		a.category_name
	  ,b.category_name
  FROM tbl_category a
  JOIN tbl_category b ON (a.ref_category_code = b.category_code);




