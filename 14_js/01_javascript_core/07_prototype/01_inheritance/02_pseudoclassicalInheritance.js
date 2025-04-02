/* 생성자 함수 기반 상속 또는 의사 클래스 상속 */

/* 부모 생성자 함수 */
// function Parent(name) {
//     this.name = name;
// }

// console.log(Parent.prototype);

// /* 부모 프로토타입 */
// Parent.prototype.sayHello = function() {
//     console.log(`Hello, I'm ${this.name}`);
// }

// /* 자식 생성자 함수 */
// function Child(name, age) {
//     Parent.call(this, name);        // 자바의 super()개념
//     this.age = age;
// }

// Child.prototype = Object.create(Parent.prototype);
// Child.prototype.constructor = Child;

// Child.prototype.sayAge = function() {
//     console.log(`I'm ${this.age} years old`);
// }

// const child = new Child('홍길동', 20);
// child.sayHello();
// child.sayAge();

/* ----------------------------------------------------- */
class Parent {
    constructor(name) {
        this.name = name;
    }

    sayHello() {
        console.log(`Hello, I'm ${this.name}`);
    }
}

class Child extends Parent {
    constructor(name, age) {
        super(name);
        this.age = age;
    }

    sayAge() {
        console.log(`I'm ${this.age} years old`);
    }
}

const child2 = new Child('유관순', 15);
child2.sayHello();
child2.sayAge();