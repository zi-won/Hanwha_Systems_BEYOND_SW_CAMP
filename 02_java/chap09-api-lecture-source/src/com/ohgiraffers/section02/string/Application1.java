package com.ohgiraffers.section02.string;

public class Application1 {
    public static void main(String[] args) {

    /* 수업목표. String 클래스의 자주 사용하는 메소드에 대해 숙지하고 응용할 수 있다. */
    /* 목차. 1. charAt() */
    String str1 = "apple";

    for (int i = 0; i < str1.length(); i++) {
        System.out.println("charAT(" + i + ") =" + str1.charAt(i));
    }

        /* 목차. 2. compareTo() */
        String str2 = "java";
        String str3 = "java";
        String str4 = "JAVA";
        String str5 = "mariaDB";
        System.out.println(str2.compareTo(str3));

        int j = 'j';
        int J = 'J';
        System.out.println("J= " + j + " J= " + J);
        System.out.println(str2.compareTo(str4));
        System.out.println(str4.compareTo(str2));
        System.out.println(str2.compareTo(str5));
        System.out.println(str5.compareTo(str2));

        /* 목차. 3. concat() */      // 문자열 합치기
        System.out.println();
        System.out.println("concat(): " + str2.concat(str5));

        /* 목차. 4. indexOf()*/      // 문자열 찾기
        String indexOf = "java mariaDB";
        System.out.println("indexOf('a') = " + indexOf.indexOf('a')); //1
        System.out.println("indexOf('z') = " + indexOf.indexOf('z')); //-1
        System.out.println("indexOf('ava') = " + indexOf.indexOf("ava")); // 1 -> 문자열 시작 인덱스 출력

        /* 목차. 5. trim() */     // 공백 제거
        String trimStr = "    java     ";
        System.out.println("trimStr = #" + trimStr + "#");
        System.out.println("trim()= #" + trimStr.trim() + "#");

        /* 목차. 6. toLowerCase()/toUpperCase() */        // 소문자로 변환/대문자로 변환
        String caseStr = "javamariaDB";

        System.out.println("toLowerCase(): " + caseStr.toLowerCase());
        System.out.println("toUpperCase(): " + caseStr.toUpperCase());

        /* 목차. 7. substring() */        // 문자열 자르기
        String javamariaDB = "java mariaDB";
        System.out.println("substring(3, 6): " + javamariaDB.substring(3, 6));
        System.out.println("substring(3): " + javamariaDB.substring(3));
        System.out.println("javamariaDB: " + javamariaDB);

        /* 목차. 8. replace() */      // 문자열 바꾸기
        System.out.println("replace(): " + javamariaDB.replace("java","python"));
        System.out.println("javamariaDB: " + javamariaDB);

        /* 목차. 9. length() */       // 문자열 길이
        System.out.println("length(): " + javamariaDB.length());
        System.out.println("빈 문자열의 길이: " + "".length());

        /* 목차. 10. isEmpty() */     // 문자열이 없으면 true, 있으면 false
        System.out.println("isEmpty(): " + "".isEmpty());   // true
        System.out.println("isEmpty(): " + "abc".isEmpty()); // false
    }
}