package com.ohgiraffers.section01.list.run;

import java.util.*;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. List 계열을 출력하는 4가지 방법 */
//        List<String> list = new ArrayList<>();
//        List<String> list = new LinkedList<>();
        List<String> list = new Vector<>();         // 동기화 처리를 위한 알고리즘이 추가되어 있다.
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add("mango");
        list.add("grape");

        /* 설명. 1. toString() 활용하기 */
        System.out.println(list);

        /* 설명. 2. for문 활용하기 */
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        /* 설명. 3. for-each문 활용하기(feat. 모든 요소를 순회하는 경우 사용) */
        for (String str : list) {
            System.out.println(str);
        }

        /* 설명. 4. iterator 활용하기 */
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        /* 설명. 1번 인덱스(두 번째)의 과일을 수정 */
        // get,set메소드 활용이 많으면 ArrayList가 더 빠르다.
        list.set(1, "pineapple");
        System.out.println("2번째 요소 수정 후: " + list);

        /* 설명. list가 관리하는 요소 제거 */
        /* 설명. 3번째 요소 제거 */
        // remove나 add(,) 사용이 많을 경우 LinkedList가 더 빠르다.
        list.remove(2);
        System.out.println("3번째 요소 제거 후: " + list);


        list.clear();   // 객체가 지워지는게 아닌 저장 값이 지워짐
        System.out.println("모든 요소 제거 후: " + list);

//        list = null;    // 리스트 객체의 참조를 삭제하는 것이므로, 리스트 자체가 더 이상 존재하지 않음.

        /* 설명. 모든 요소가 제거된 이후 */
        System.out.println("isEmpty: " + list.isEmpty());
        // list.clear() -> true, list = null -> NullPointerException 오류 발생

        /* 설명. null과 '객체는 있지만 비어있음' 을 잘 구분하자! */

    }
}
