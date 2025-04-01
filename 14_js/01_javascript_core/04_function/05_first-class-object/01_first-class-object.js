/*
  일급객체의 특징
  1. 무명의 리터럴로 생성할 수 있다. 즉, 런타임에 생성이 가능하다.
  2. 변수나 자료구조(객체, 배열 등)에 저장할 수 있다.
  3. 함수의 매개변수로 전달할 수 있다.
  4. 함수의 반환값으로 사용할 수 있다. 
*/

/* 1, 2번에 해당 */
var hello = function() {
    return '안녕하세요';
};

/* 3번에 해당 */
function repeat(func, count) {
    for(var i = 0; i < count; i++) {
        console.log(func());
    }

    /* 4번에 해당 */
    /* 렉시컬 환경(자신이 생성된 환경)을 활용한 함수를 반환(이렇게 반환된 함수를 클로저 함수) */
    return function() {
        console.log(`${count}번 반복 완료`);
    }
}

repeat(hello, 5)();