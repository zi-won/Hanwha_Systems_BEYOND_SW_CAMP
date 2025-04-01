var message;

message = function() {
    return "Hello World!";
};

console.log(message());

message = () => {
    return "Arrow Function!";
};
console.log(message());

/* 중괄호 생략: 함수 내부 실행 구문이 하나만 있는 경우 */
/* return 생략: 하나의 값 또는 하나의 값으로 취급할 수 있는 표현식일 경우 암묵적으로 return됨 */
message = () => "Arrow Function2!";
message = () => 1 + 2;
console.log(message());

message = (val1, val2) => "Arrow" + val1 + val2;
console.log(message('function3', '!'));

/* 소괄호 생략: 매개변수가 하나만 있을 경우 */
message = val1 => "Arrow " + val1;
console.log(message("Function4!"));