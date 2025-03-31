var sym1 = Symbol();
var sym2 = Symbol();
console.log(sym1 == sym2);

var sym3 = Symbol('설명');
var sym4 = Symbol('설명');
console.log(sym3 == sym4);
console.log(sym3.description);
console.log(sym4.description);

var obj = {};            // 리터럴 객체({})를 생성해서 추후에 동적으로 프로퍼티(속성)를 추가 및 제거할 수 있다.
obj['일반속성'] = '일반';   // 대괄호([])는 객체의 속성에 접근 또는 없으면 추가하는 개념
obj[sym3] = '값1';
obj[sym4] = '값2';

console.log(obj);
console.log(typeof obj);
console.log(obj[sym3]);

/* 숨겨진 프로퍼티 */
var hidden = Symbol('숨겨진 프로퍼티');
obj[hidden] = '비밀 값';
obj['name'] = '홍길동';
console.log(obj);
console.log(obj[hidden]);
console.log(Object.keys(obj));