-- ddl(data definition language)
CREATE TABLE tb1 (
	 pk INT PRIMARY KEY,
	 fk INT,
	 col1 VARCHAR(255),
	 CHECK(col1 IN ('y', 'n'))
);

-- 존재하는 테이블을 요약해서 간략히 보고 싶다면 desc 키워드 사용
DESCRIBE tb1;
DESC tb1;

INSERT
  INTO tb1
VALUES
(
	1, 2, 'y'
);

-- auto_increment
-- if not exsists: 존재하면 애러 x
-- drop: table 삭제
DROP TABLE tb2;								-- 관례상 기존 테이블을 지우고 새로 만들기 위해 create 보다 위에 쓴다.

CREATE TABLE if not exists tb2 (
  pk INT PRIMARY KEY AUTO_INCREMENT,	-- auto_incremnet를 써줌으로써 중복된 값을 넣어도 자동으로 1씩 올라간다.(null값 포함)
  fk INT,
  col1 VARCHAR(255),
  CHECK(col1 IN('y', 'n'))
);

DESC tb2;

INSERT
  INTO tb2
VALUES
(
  NULL, 2, 'n'
);

SELECT * FROM tb1;
COMMIT;											-- autocommit을 꺼놨기 때문에 항상 commit을 해주어야 한다.

-- ----------------------------------------------------------
-- alter
-- 컬럼 추가
ALTER TABLE tb2 ADD col2 INT NOT NULL;	-- null값 허용 x
DESC tb2;

-- 컬럼 삭제
ALTER TABLE tb2 DROP COLUMN col2;
DESC tb2;

-- 컬럼 이름 및 컬럼 정의 변경
ALTER TABLE tb2 CHANGE COLUMN fk CHANGE_fk INT NOT NULL;
DESC tb2;

-- auto_incremnet 먼저제거(DROP 아닌 MODIFY)
ALTER TABLE tb2 MODIFY pk INT;
-- 다시 primary key 제거
ALTER TABLE tb2 DROP PRIMARY KEY;

DESC tb2;

-- truncate
-- 절삭(truncate) vs 삭제(delete)
-- 테이블의 데이터(데이터 및 관련 제약조건 등 깔끔하게 제거)
-- 테이블의 초기화(테이블을 초기 만들 당시로 돌려줌)
CREATE TABLE if NOT EXISTS tb3 (
	pk INT AUTO_INCREMENT,
	fk INT,
	col1 VARmenudbCHAR(255) CHECK(col1 IN ('y', 'n')),
	PRIMARY KEY(pk)
);

INSERT
  INTO tb3
VALUES
(
  NULL, 1, 'n'
);

SELECT * FROM tb3;

TRUNCATE TABLE tb3;






