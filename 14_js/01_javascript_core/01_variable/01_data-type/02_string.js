var str = '안녕하세요';
console.log(typeof str);

/* 백틱(`)키를 이용하면 여러줄 문자열을 인식할 수 있다. */
var str2 = `안녕하세요.
반갑습니다.`;
console.log("multiline: " + str2);      // 문자열은 홀따옴표(') 또는 쌍따옴표(") 모두 가능

/* Template Literal */
/* 표현식 삽입(${}, Template Literal)과 백틱(`)을 함께 사용하면 가독성도 좋고 간편하게
   작성 가능 (표현식: 하나의 리터럴 값이 되게 하는 식) */
var lastName = '길동';
var firstName = '홍';
console.log('제 이름은 ' + lastName + ' ' + firstName + '입니다.');
console.log(`제 이름은 ${lastName} ${firstName}입니다.`);