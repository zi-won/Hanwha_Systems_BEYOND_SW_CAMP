
/* 정규 표현식 */
let regex = /j/i;   // 패턴: j, 플래그 옵션: i => 대소문자 구분 없이(case insensitive)
regex = new RegExp('j', 'i');
regex = new RegExp(/j/, 'i');
regex = new RegExp(/j/i);

let target = "JavaScript";

/* 유효성 검사(validation check)를 할 수 있다. */
console.log(regex.test(target));        // target 문자열이 패턴에 맞으면 true(유효하다)