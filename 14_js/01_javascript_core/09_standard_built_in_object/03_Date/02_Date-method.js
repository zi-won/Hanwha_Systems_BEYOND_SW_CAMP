const now = Date.now();
console.log(new Date(now));

const date = new Date();

console.log(Object.getOwnPropertyDescriptors(date));
console.log(date.getFullYear());
console.log(date.getMonth() + 1);           // 0 ~ 11 체계의 월을 고려
console.log(date.getDate());
console.log(date.getDay());                 // 0 ~ 6(0: 일요일, 1: 월요일, ...)
console.log(date.getHours());
console.log(date.getMinutes());
console.log(date.getSeconds());
console.log(date.getMilliseconds());

date.setFullYear(2025);
date.setMonth(4-1);
date.setDate(2);
date.setHours(12);
date.setMinutes(33);
date.setSeconds(10);
console.log(date);
console.log(date.getDay());