package com.ohgiraffers.section02.looping;

public class Application {
    public static void main(String[] args) {

        A_for aClass = new A_for();
//        aClass.testSimpleForStatement();
//        aClass.testForExample();
//        aClass.testForExample2();

        B_nestedFor bClass = new B_nestedFor();
//        bClass.printGugudanFromTwoToNice();
//        bClass.printStars();

        C_while cClass = new C_while();
//        cClass.testSimpleWhileStatement();
//        cClass.testWhileExample();

        D_doWhile dClass = new D_doWhile();
        dClass.testSimpleDoWhileStatement();
//        dClass.testDoWhileExample();
    }
}
