package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. BufferedWriter와 BufferedReader에 대해 이해하고 사용할 수 있다. */
        /* 설명.
         *  내부적으로 버퍼(buffer)를 활용해서 입출력 성능을 향상 시킨다.
         *  추가적인 메소드가 제공된다.
         * */

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(        // 기반 스트림
                    new FileWriter("src/main/java/com/ohgiraffers/section03/filterstream/testBuffered.txt"));

            bw.write("눈이\n");
            bw.write("하늘에서\n");
            bw.write("내려오네");
            /* 설명. 내부적으로 버퍼가 다 차지 않으면 출력으로 내보내 지지 않는데 flush()를 사용하여 버퍼를 비워줌으로 써 모두 출력함 */
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(bw != null) bw.close();  // close 내부에 flush메소드가 있어서 출력을 하려면 flush든 close든 하나를 사용해야한다.
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new FileReader(
                    "src/main/java/com/ohgiraffers/section03/filterstream/testBuffered.txt"
                    )
            );

//            String str = br.readLine();
//            System.out.println("str = " + str);
            String str = "";
            while((str = br.readLine()) != null) {
                System.out.println("str = " + str);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(br != null) br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
