-- trigger
delimiter //

CREATE OR REPLACE TRIGGER after_order_menu_insert
	 AFTER insert
	 ON tbl_order_menu
	 FOR EACH ROW		-- insert가 발생하면 이 작업을 또 해라(주문 여러 개가 들어올 시), 없을 시 insert가 2번 들어오더라도 1번만 동작함
BEGIN
    UPDATE tbl_order
    SET total_order_price = total_order_price + NEW.order_amount *
    (SELECT menu_price FROM tbl_menu WHERE menu_code = NEW.menu_code)
    WHERE order_code = NEW.order_code;
END //

delimiter ;

-- 주문 테이블(tbl_order)에 insert 후 주문 메뉴 테이블(tbl_order_menu)에 주문한 메뉴마다 insert한 후
-- 주문 테이블의 총 금액이 insert 할 때마다 업데이트 되는지 확인하자.

-- 1) 주문 테이블 insert
INSERT
  INTO tbl_order
(
  order_code, order_date
, order_time, total_order_price

)
VALUES
(
  NULL
, CONCAT(CAST(YEAR(NOW()) AS VARCHAR(4))
		 , CAST(LPAD(MONTH(NOW()), 2, 0) AS VARCHAR(2))
		 , CAST(LPAD(DAYOFMONTH(NOW()), 2, 0) AS VARCHAR(2))
		 )
, CONCAT(CAST(LPAD(HOUR(NOW()), 2, 0) AS VARCHAR(2))
		 , CAST(LPAD(MINUTE(NOW()), 2, 0) AS VARCHAR(2))
		 , CAST(LPAD(SECOND(NOW()), 2, 0) AS VARCHAR(2))
		 )
, 0
);

SELECT * FROM tbl_order;
SELECT * FROM tbl_menu;

-- '우럭스무디' 3개 주문
INSERT
  INTO tbl_order_menu
(order_code, menu_code, order_amount)
VALUES
(1, 2, 3);

-- 추가로 같은 주문에서
INSERT
  INTO tbl_order_menu
(order_code, menu_code, order_amount)
VALUES
(1, 13, 4);

-- 상품 입출고와 관련된 trigger 활용 예시
-- 1) 이력 테이블(update가 발생하는 테이블)
CREATE TABLE product(
	 pcode INT PRIMARY KEY AUTO_INCREMENT,
	 pname VARCHAR(30),
	 brand VARCHAR(30),
	 price INT,
	 stock INT DEFAULT 0,
	 CHECK(stock >= 0)
);

-- 2) 내역 테이블(insert가 발생하는 테이블)
CREATE TABLE pro_detail(
	 dcode INT PRIMARY KEY AUTO_INCREMENT,
	 pcode INT,
	 pdate DATE,
	 amount INT,
	 STATUS VARCHAR(10) CHECK(STATUS IN ('입고', '출고')),
	 FOREIGN KEY(pcode) REFERENCES product		-- 무조건 부모 테이블의 pk가 넘어와야 되므로 생략 가능(pcode)
);

-- 입출고용 트리거 생성
delimiter //

CREATE OR REPLACE TRIGGER trg_productafter
	 AFTER insert
	 ON pro_detail
	 FOR EACH row
BEGIN
	 if NEW.status = '입고' then
	 	 UPDATE product
	 	 	 SET stock = stock + NEW.amount
	 	  WHERE pcode = NEW.pcode;
	 ELSEIF NEW.status = '출고' then
	 	 UPDATE product
	 	 	 SET stock = stock - NEW.amount
	 	  WHERE pcode = NEW.pcode;
	 END if;
END //

delimiter ;

-- 만든 트리거 확인
SHOW TRIGGERS;

-- product 테이블에 기본 상품 추가
INSERT
  INTO product
(
  pcode, pname, brand
, price, stock
)
VALUES
(
  NULL, '갤럭시플립', '삼송'
, 900000, 5
),
(
  NULL, '아이펀17', '아이뽕'
, 1100000, 5
),
(
  NULL, '투명폰', '삼송'
, 2100000, 5
);
SELECT * FROM product;

-- 내역 테이블에 insert 시행(입출고 진행)
INSERT
  INTO pro_detail
(
  dcode, pcode, pdate
, amount, STATUS
)
VALUES
(
  NULL, 3, CURDATE()
, 4, '입고'
);
SELECT * FROM product;
SELECT * FROM pro_detail;

INSERT
  INTO pro_detail
(
  dcode, pcode, pdate
, amount, STATUS
)
VALUES
(
  NULL, 2, CURDATE()
, 5, '출고'
);
SELECT * FROM product;
SELECT * FROM pro_detail;









