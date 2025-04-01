function Student(name, age) {
    this.name = name;               // 단순 함수일 때 내부의 this.은 전역 객체를 말한다.
    this.age = age;
    this.getInfo = function() {
        return `${this.name}(은)는 ${this.age}세 입니다.`;
    }

    return this.getInfo;
};

/* new 연산자를 안 붙이고 일반 함수로 썼을 때 내부의 this는
   전역객체이며 함수명만 대문자로 시작하는 상태 */
const student = Student('강감찬', 35);      // 일반 함수로써 활용 시
console.log(student);

// console.log(this);          // 가짜 전역 객체
// console.log(globalThis);

/*
  생성자 함수가 일반 함수와 차이나도록 new 연산자 없이 호출되어도 객체가 생성되는
  빌트인 함수로 만들 수 있다.(feat. new.target을 활용)
*/
function Dog(name, age) {
    console.log('new.target:', new.target);

    if(!new.target) {           // 이 함수가 new 연산자로 호출되지 않으면 true가 되게 작성
        return new Dog(name, age);
    }

    this.name = name;           // 여기서의 this는 생성자 함수로 만들어질 객체
    this.age = age;
}

const dog = new Dog('뽀삐', 3);
console.log(dog);

/* 제공되는 빌트인 함수들: Object, String, Number, Boolean, Date, Regex, .... */