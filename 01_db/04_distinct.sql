-- distinct(중복값 제거)
-- 메뉴가 할당된 카테고리를 조회
SELECT
		 category_code
  FROM tbl_menu
 ORDER BY category_code;
 
-- distinct를 활용해 메뉴가 할당된 카테고리들의 종류를 조회
SELECT
		 distinct category_code
  FROM tbl_menu
 ORDER BY category_code;
 
-- 다중열 distinct
SELECT
		 distinct
		 category_code
	  , orderable_status
  FROM tbl_menu;