package com.ohgiraffers.section02.set.run;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. LinkedHashSet에 대해 이해하고 활용할 수 있다. */
        /* 설명.
         *  LinkedHashSet은 저장 당시의 순서를 유지하는 특성을 갖고 있다.
         *  (중복 제거 + 순서 유지)
         * */
        Set<String> lSet = new LinkedHashSet<>();
        lSet.add("ramen");
        lSet.add("pork");
        lSet.add("kimchi");
        lSet.add("friedEgg");
        lSet.add("soup");
        System.out.println("lSet: " + lSet);

        Iterator<String> iter = lSet.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
