-- dml(data manipulation language)
-- insert, update, delete, select(dml)

-- insert
-- 새로운 행을 추가하는 구문
SELECT * FROM tbl_menu;
INSERT
  INTO tbl_menu
(
  menu_name
, menu_price
, category_code
, orderable_status
)
VALUES
(
  '초콜릿죽'
, 6500
, 7
, 'y'
);
DESC tbl_menu;

-- 컬럼명 미작성시에는 실제 테이블의 컬럼 갯수만큼 컬럼 순서를 지켜 작성해야 한다.
-- 하나의 insert 구문으로 여러 데이터를 insert 할 수 있다.(multi-insert)
INSERT
  INTO tbl_menu
VALUES
(NULL, '참치맛아이스크림', 1700, 12, 'y'),
(NULL, '멸치맛아이스크림', 1500, 11, 'y'),
(NULL, '소시지맛커피', 2500, 8, 'y');

SELECT * FROM tbl_menu ORDER BY 1 DESC;

-- update
-- 테이블에 기록된 컬럼값을 수정하는 구문이다.
-- 전체 행 갯수에는 변화가 없다.
SELECT
		 *
  FROM tbl_menu;

UPDATE tbl_menu
	SET category_code = 8,
		 menu_price = 200
 WHERE menu_code = 25;

-- subquery를 활용한 update
UPDATE tbl_menu
	SET category_code = 8,
		 menu_price = 200
 WHERE menu_code = (SELECT menu_code
 							 FROM tbl_menu
 							WHERE menu_name = '참치맛아이스크림');
SELECT * FROM tbl_menu;

-- delete
-- 테이블의 행을 삭제하는 구문
-- 테이블의 행의 갯수가 줄어든다.
-- mariadb는 기본적으로 autocommit이 true로 설정되어 있다.

SET autocommit = 1;				-- autocommit 켜기
SET autocommit = ON;

SET autocommit = 0;				-- commit이 되어버리면 위험하기 때문에 자동 커밋을 꺼버림으로써 안전장치 설정
SET autocommit = OFF;

DELETE
  FROM tbl_menu
 WHERE 1 =1;						-- where절을 안썻을 때 경고 없애주는 편법
 
SELECT * FROM tbl_menu;
ROLLBACK;
COMMIT;

-- order by 및 limit을 통해 삭제(update, delete)할 수 있다.
DELETE
  FROM tbl_menu
 ORDER BY menu_price				-- 메뉴가격 오름차순
 LIMIT 2;							-- 정렬된 첫 행부터 2행의 행에 해당(2행 출력으로 제한)

-- replace
REPLACE 
	into tbl_menu					-- into 생략 가능
VALUES
(
	17
, '참기름소주'
, 5000
, 10
, 'y'
);

SELECT * FROM tbl_menu WHERE menu_code = 17;



