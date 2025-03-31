console.log(10 + '20');
console.log(`10 + 20: ${10 + 20}`);

console.log(1 + '');
console.log(NaN + '');
console.log(Infinity + '');
console.log(true + '');
console.log(null + '');
console.log(undefined + '');
// console.log(Symbol() + '');
console.log({} + '');           // 리터럴 객체
console.log([1, 2] + '');       // 배열
console.log(function(){} + ''); // 함수