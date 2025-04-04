
/* 스프레드 문법을 활용한 배열 및 객체 복사 */

/* 1. 배열 복사 */
let arr = [10, 40, 80];
let arrCopy = [...arr];         // 깊은 복사(사본)

console.log(arr);
console.log(arrCopy);
console.log(arr === arrCopy);

/* 2. 객체 복사 */
let obj = {
    name: '홍길동',
    age: 20,
    addr: '서울',
    hobbies: ['축구', '농구']
};

let objCopy = {...obj};     // 객체의 프로퍼티들을 전개

console.log(obj);
console.log(objCopy);
console.log(obj === objCopy);

/* 객체 내부에 추가적인 객체들(객체 또는 배열)이 있을 경우 완벽한 복사를 위해서 추가적으로 
   작업해 주어야 한다. */
console.log(obj.hobbies === objCopy.hobbies);       // true
objCopy.hobbies = [...obj.hobbies];
console.log(obj.hobbies === objCopy.hobbies);       // false

let classNum = 30;      // 추가
let name = '강감찬';    // 수정

/* 프로퍼티 값 단축 문법 + 스프레드 문법 */
let newObj = {classNum, ...obj, name};              // 수정해야 할 프로퍼티는 순서에 유의
console.log(newObj);