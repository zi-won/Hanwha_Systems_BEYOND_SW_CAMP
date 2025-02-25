package com.ohgiraffers.section02.set.run;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. TreeSet에 대해 이해하고 활용할 수 있다. */
        /* 설명. Tree 구조를 활용해 중복 제거 + 정렬을 해준다. */
        Set<String> tSet = new TreeSet<>();
        tSet.add("ramen");
        tSet.add("pork");
        tSet.add("kimchi");
        tSet.add("friedEgg");
        tSet.add("soup");
        tSet.add("soup");
        System.out.println("tSet = " + tSet);

        /* 설명. 로또 번호 발생기(feat.보너스 번호 추출 제외)
         *   1부터 45까지 중복되지 않고 오름차순 정렬된 6개의 값 추출하기
         * */
        Set<Integer> lotto = new TreeSet<>();

        while(lotto.size() < 6) {
            lotto.add((int)(Math.random() * 45) + 1);
        }
        System.out.println("lotto = " + lotto);

        /* 설명. 배열을 활용한 TreeSet과 같은 기능(정렬은 빼고)을 하는 알고리즘 구현해 보기 */
        /* 설명. 1부터 45까지의 난수를 생성해 중복되지 않은 6개의 값을 배열에 저장하기 */
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 45) + 1;

            /* 설명. 이전 생성된 값들과 비교 */
            i = duplicateValidation(i, arr);
        }

        System.out.println("배열에 담긴 값: " + Arrays.toString(arr));

    }

    private static int duplicateValidation(int current, int[] arr) {
        for (int j = 0; j < current; j++) {
            if (arr[current] == arr[j]) {
                current--;
                break;
            }
        }
        return current;
    }
}