const foodList = ['물회', '삼계탕', '냉면', '수박', '물회'];

console.log(`foodList.indexOf('물회'): ${foodList.indexOf('물회')}`);   // 중복되면 좌측 우선
console.log(`foodList.indexOf('삼겹살'): ${foodList.indexOf('삼겹살')}`);  // -1(없으면)

console.log(`foodList.includes('물회'): ${foodList.includes('물회')}`);
console.log(`foodList.includes('삼겹살'): ${foodList.includes('삼겹살')}`);

const chineseFood = ['짜장면', '짬뽕', '탕수육'];

/* 마지막 요소로 추가 */
chineseFood.push('팔보채');
chineseFood.push('양장피');
console.log(`push 후: ${chineseFood}`);

/* 마지막 요소를 제거 */
console.log(`chineseFood.pop(): ${chineseFood.pop()}`);
console.log(`chineseFood.pop(): ${chineseFood.pop()}`);
console.log(`pop 후: ${chineseFood}`);

const chickenList = ['양념치킨', '후라이드', '파닭'];

/* 처음 요소로 추가 */
console.log(`chickenList.unshift(): ${chickenList.unshift('간장치킨')}`);
console.log(`chickenList.unshift(): ${chickenList.unshift('마늘치킨')}`);
console.log(`unshift 후: ${chickenList}`);

/* 처음 요소를 제거 */
console.log(`chickenList.shift(): ${chickenList.shift()}`);
console.log(`shift 후: ${chickenList}`);

/* concat */
const idol1 = ['서태지와 아이들', '소녀시대'];
const idol2 = ['HOT', '젝스키스'];
const idol3 = ['핑클', '블랙핑크'];

console.log(`idol1을 기준으로 idol2 배열을 concat: ${idol1.concat(idol2)}`);

/* ES6에서는 스프레드 연산자를 활용해서 concat의 개념을 할 수도 있다.(이후 배울 내용) */
console.log(`idol1을 기준으로 idol2 배열을 concat(spread): ${[...idol1, ...idol2]}`);
console.log(...idol1);

console.log(`idol3를 기준으로 idol1, idol2를 concat: ${idol3.concat(idol1, idol2)}`);
console.log(`idol3를 기준으로 idol1, idol2를 concat(spread): ${[...idol3, ...idol1, ...idol2]}`);

/* slice(선택한 요소 복사) / splice(선택한 인덱스 위치 요소 제거 및 추가) */
const front = ['HTML', 'CSS', "JavaScript", "Vue"];

console.log(`front.slice(): ${front.slice(1, 3)}`);  // 1~2인덱스까지 복사
console.log(`front: ${front}`);

console.log(`front.splice(): ${front.splice(2, 2, 'JDBC')}`);   // 2번 인덱스 부터 이후 
                                                                // 2개를 제거하고 추가
console.log(`front: ${front}`);

/* join(배열에 담긴 값들을 우리가 원하는 구분자를 포함한 문자열로 변환) */
const snackList = ['사탕', '초코렛', '껌', '마이쮸'];
console.log(`snackList.join(): ${snackList.join()}`);
console.log(`snackList.join('/'): ${snackList.join('/')}`);