SELECT menu_name, menu_code FROM tbl_menu;

SELECT
		 menu_name
		, menu_code
		, category_code
	FROM tbl_menu;
	
SELECT
		 *
	FROM tbl_menu;
	
-- ---------------------------

SELECT
		 *
	FROM tbl_category;
-- ---------------------------
-- FROM절 없는 SELECT 해보기
SELECT 7 + 3;
SELECT 10 * 2;
SELECT 6 % 3, 6 % 4;
SELECT NOW();			--서버의 현재시간
SELECT CONCAT('유', ' ', '관순');		-- 문자 붙이기

-- 별칭(alias)
SELECT 7 + 3 AS 합;
SELECT 2 * 3 AS '곱입니다.';		-- 특수기호(띄어쓰기를 포함한)사용 시에는 (')싱글 쿼테이션 생략 불가
											-- AS 생략 가능하지만 가독성을 위해 생략하지 말자.

SELECT menu_name AS 메뉴명 FROM tbl_menu;