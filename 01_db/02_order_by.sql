-- order by(정렬)

-- 오름차순(Ascending, ASC)
-- 내림차순(Descending, DESC)
SELECT
		menu_code
		, menu_name
		, menu_price
  FROM tbl_menu
--  ORDER BY menu_price ASC;
--  ORDER BY menu_price;							-- 생략가능(생략 시 ASC)
--  ORDER BY menu_price, menu_name DESC;		-- 정렬의 우선순위를 가지고 여러 정렬 기준 적용 가능
 ORDER BY 3, 2 DESC;									-- select 절에 작성한 컬럼 순번 활용 가능
 
-- 별칭을 이용한 정렬
SELECT
		menu_code AS 메뉴코드
		, menu_name AS 메뉴명
		, menu_price AS 메뉴단가
  FROM tbl_menu
 ORDER BY 메뉴코드 DESC;								--	-별칭에 특수기호가 있을 시 별칭을 활용한 정렬 x(특수기호 쓰지 말자)
 
-- field 함수를 활용한 정렬이 가능하다.
SELECT FIELD('a', 'b', 'c', 'a');

-- 주문 불가능한 메뉴부터 보기
SELECT
		 orderable_status
		, FIELD(orderable_status, 'Y', 'N') AS 가능여부
  FROM tbl_menu
--  ORDER BY FIELD(orderable_status, 'Y', 'N') DESC;
--  ORDER BY 2 DESC;
 ORDER BY 가능여부 DESC;
 
-- -------------------------------------------
-- null 값(비어 있는 컬럼 값)에 대한 정렬
SELECT * FROM tbl_category;

-- 1) 오름차순 시: null값이 먼저 나옴
SELECT
		 *
  FROM tbl_category
 ORDER BY ref_category_code ASC;
 
-- 2) 내림차순 시: null값이 마지막에 나옴
SELECT
		 *
  FROM tbl_category
 ORDER BY ref_category DESC;
 
 -- 3) 오름차순 시: null값이 마지막에 나옴
SELECT
		 *
  FROM tbl_category
 ORDER BY -ref_category_code DESC;	-- desc를 통해 null의 위치(나중)를 선정하고 desc와 반대(asc)로 컬럼값 정렬
 
-- 4) 내림차순 시: null값이 먼저 나옴
SELECT
		 *
  FROM tbl_category
 ORDER BY -ref_category ASC;			-- asc를 통해 null의 위치(먼저)를 선정하고 asc와 반대(desc)로 컬럼값 정렬



