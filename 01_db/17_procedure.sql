-- stored procedure
-- 저장해둔 일련의 sql 문장을 불러와 반복 재사용함으로써 반복적인 작업을 효율화할 수 있다.
-- 반복적인 작업을 효율화
-- 네트워크 트래픽을 줄일 수 있다.(DB에서 일어나는 일이기 때문)

delimiter //

CREATE OR REPLACE PROCEDURE getAllEmployees()
BEGIN
	 SELECT emp_id, emp_name, salary
	   FROM employee;
END //

delimiter ;

call getAllEmployees();

-- ------------------------------------------------------------------------------------------
-- IN 매개변수
delimiter //

CREATE OR REPLACE PROCEDURE getEmployeeByDepartment (
	 IN dept CHAR(2)
)
BEGIN
	 SELECT emp_id, emp_name, salary, dept_code
	 FROM employee
	 WHERE dept_code = dept;
END //

delimiter ;

CALL getEmployeeByDepartment('d5');
CALL getEmployeeByDepartment('d6');
CALL getEmployeeByDepartment('d2');

-- -----------------------------------------------------------------------------
-- OUT 매개변수
delimiter //

CREATE OR replace PROCEDURE getEmployeeSalary(
	 IN id VARCHAR(3),
	 OUT sal DECIMAL(10, 2)
)
BEGIN
	 SELECT salary INTO sal
	 FROM employee
	 WHERE emp_id = id;
END //

delimiter ;

SET @sal = 0;
CALL getEmployeeSalary('201', @sal);
SELECT @sal;

-- ------------------------------------------------
-- inout 매개변수
delimiter //

CREATE OR REPLACE PROCEDURE updateAndReturnSalary (
	 IN id VARCHAR(3),
	 INOUT sal DECIMAL(10, 2)
)
BEGIN
	 UPDATE employee
	 SET salary = sal
	 WHERE emp_id = id;
	 
	 SELECT salary + (salary * IFNULL(bonus, 0)) INTO sal		
	 FROM employee
	 WHERE emp_id = id;
END //

delimiter ;

SET @new_sal = 9000000;
CALL updateAndReturnSalary('200', @new_sal);
SELECT @new_sal;

-- 연산 시 null이 들어가면 결과가 무조건 null이므로 ifnull 또는 nvl함수를 활용해야 한다.
SELECT
		 salary
	  , bonus
	  , emp_name
	  , salary * bonus AS 보너스
	  , salary + salary * ifnull(bonus, 0) AS 보너스포함급여  -- ifnull: 값이 있으면 bonus, null이면 0
	  , salary + salary * nvl(bonus, 0) AS 보너스포함급여
  FROM employee;
  
-- @변수의 의미
-- 1) '사용자 정의형 변수'
-- 2) 크기를 따로 정하지 않지만 대입되는 값에 맞춰진다.
-- 3) 전역 변수의 의미를 가짐

-- -----------------------------------------------------------------------------
-- if-else 활용
delimiter //

CREATE OR REPLACE PROCEDURE checkEmployeeSalary(
	 IN id VARCHAR(3),
	 IN threshold DECIMAL(10, 2),
	 OUT result VARCHAR(50)
)
BEGIN
	 DECLARE sal DECIMAL(10, 2);
	 
	 SELECT salary INTO sal
	 FROM employee
	 WHERE emp_id = id;
	 
	 if sal > threshold then
	 	 SET result = '기준치를 넘는 급여입니다.';
	 else
	 	 SET result = '기준치와 같거나 기준치 미만의 급여입니다.';
	 END if;
END //

delimiter ;

SET @result = '';
CALL checkEmployeeSalary('200', 3000000, @result);
SELECT @result;

-- --------------------------------------------------------------------
-- case
delimiter //

CREATE OR REPLACE PROCEDURE getDepartmentMessage(
	 IN id VARCHAR(3),
	 OUT message VARCHAR(100)
)
BEGIN
	 DECLARE dept VARCHAR(50);
	 
	 SELECT dept_code INTO dept
	 FROM employee
	 WHERE emp_id = id;
	 
	 case
			when dept = 'd1' then
				SET message = '인사관리부 직원이시군요!';
			when dept = 'd2' then
				SET message = '회계관리부 직원이시군요!';
			when dept = 'd3' then
				SET message = '마케팅부 직원이시군요!';
			else
				SET message = '어떤 부서 직원이신지 모르겠어요!';
	 END case;
END //

delimiter ;

SET @message = '';
CALL getDepartmentMessage('221', @message);
SELECT @message;

-- -------------------------------------------------------------
-- while 활용
delimiter //

CREATE OR REPLACE PROCEDURE calculateSumUpTo(
	 IN max_num INT,
	 OUT sum_result int
)
BEGIN
	 DECLARE current_num INT DEFAULT 1;
	 DECLARE total_sum INT DEFAULT 0;
	 
	 while current_num <= max_num do
	 	  SET total_sum = total_sum + current_num;
	 	  SET current_num = current_num + 1;
	 END while;
	 
	 SET sum_result = total_sum;
END //
	 

delimiter ;

SET @result = 0;
CALL calculateSumUpTo(10, @result);
SELECT @result;

-- -----------------------------------------------------------------------------------
-- 예외 처리
delimiter //

CREATE OR REPLACE PROCEDURE divideNubers(
	 IN numerator DOUBLE,
	 IN denomitor DOUBLE,
	 OUT result DOUBLE
)
BEGIN
	 DECLARE division_by_zero CONDITION FOR SQLSTATE '45000';
	 DECLARE exit handler FOR division_by_zero;
	 begin
	 	  SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = '0으로 나눌 수 없습니다.';
	 END;
	 
	 if denominator = 0 then
	 	  SIGNAL division_by_zero;
	 else
	 	  SET result = numerator / denominator;
	 END if;
END //

delimiter ;

SET @result = 0;
CALL divideNubers(10, 2, @result);
SELECT @result;
CALL divideNubers(10, 0, @result);	--나누는 수가 0일 때 division_by_zero 예외 처리가 동작함

-- --------------------------------------------------------
-- stored function
delimiter //

CREATE OR REPLACE FUNCTION getAnnualSalary(
	 id VARCHAR(3)
)
RETURNS DECIMAL(15, 2)
deterministic
BEGIN
	 DECLARE monthly_salary DECIMAL(10, 2);
	 DECLARE annual_salary DECIMAL(15, 2);
	 
	 SELECT salary INTO monthly_salary
	 FROM employee
	 WHERE emp_id = id;
	 
	 SET annual_salary = monthly_salary * 12;
	 
	 RETURN annual_salary;
END //

delimiter ;

SELECT
		 emp_name
	  , getAnnualSalary(emp_id) AS '연봉'
  FROM employee;







