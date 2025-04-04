
/* 배열 구조 분해 할당 */

let nameArr = ["Gildong", "Hong", "!"];
// let firstName = nameArr[0];
// let lastName = nameArr[1];

/* 불필요한 요소를 제외한 필요한 값들만 변수에 담을 수도 있다. */
let [firstName, ,lastName] = nameArr;    // 배열 구조 분해 할당(해당 인덱스 위치의 변수에 대입됨)

console.log('firstName:',firstName);
console.log('lastName:',lastName);

let name = 'Saimdang Shin';
let [firstName2, lastName2] = name.split(' ');
console.log('firstName2:',firstName2);
console.log('lastName2:',lastName2);

let [firstName3, lastName3] = name.match(/[a-z]+/gi);
console.log('firstName3:',firstName3);
console.log('lastName3:',lastName3);