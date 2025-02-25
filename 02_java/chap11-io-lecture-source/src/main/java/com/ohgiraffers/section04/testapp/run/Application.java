package com.ohgiraffers.section04.testapp.run;

import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.service.MemberService;

import java.util.Scanner;

public class Application {

    private static final MemberService ms = new MemberService();    // 회원관리 기능 수행

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("====== 회원 관리 프로그램 ======");
            System.out.println("1. 모든 회원 정보 보기");
            System.out.println("2. 회원 찾기");
            System.out.println("3. 회원 가입");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원 탈퇴");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1: ms.findAllMembers(); break;                 // 모든 회원 정보 출력
                case 2: ms.findAllMemberBy(chooseMemNo()); break;   // 특정 회원 번호 입력 받아 해당 회원을 찾음
                case 3: ms.registMember(singUp());break;
                case 4: Member selected = ms.findMemberForMod(chooseMemNo());
                        if (selected == null) continue;     // 반복문 처음으로 돌아감
                        ms.modifyMember(reform(selected));
                        break;
                case 5: ms.removeMember(chooseMemNo()); break;
                case 9:
                    System.out.println("회원관리 프로그램을 종료합니다."); return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    /* 설명. 회원 수정 페이지 */
    private static Member reform(Member modifyMember) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== 회원 정보 수정 서브 메뉴 =====");
            System.out.println("1. 패스워드");
            System.out.println("2. 나이");
            System.out.println("3. 취미");
            System.out.println("4. 혈액형");
            System.out.println("9. 메인 메뉴로 돌아가기");
            System.out.print("내용을 선택하세요: ");
            int chooseNo = sc.nextInt();
            sc.nextLine();      // 버퍼의 엔터 제거용
            switch (chooseNo) {
                case 1:
                    System.out.print("수정할 패스워드를 입력하세요:");
                    modifyMember.setPwd(sc.nextLine());
                    break;
                case 2:
                    System.out.print("수정할 나이를 입력하세요: ");
                    modifyMember.setAge(sc.nextInt());
                    break;
                case 3:
                    System.out.print("수정할 취미를 입력하세요: ");
                    modifyMember.setHobbies(resetHobbies());    // 배열은 단순 Scanner로 입력 X
                    break;
                case 4:
                    System.out.print("수정할 혈액형을 입력하세요: ");
                    modifyMember.setBloodType(resetBloodtype());    // enum은 단순 Scanner로 입력 X
                    break;
                case 9:
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return modifyMember;
                default:
                    System.out.println("번호를 다시 제대로 입력해 주세요.");
            }
        }
    }

    private static BloodType resetBloodtype() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 혈액형을 입력하세요.(A, AB, B, O)");
        String bloodType = sc.nextLine().toUpperCase();
        BloodType bt = null;
        switch (bloodType) {
            case "A": bt = BloodType.A; break;
            case "AB": bt = BloodType.AB; break;
            case "B": bt = BloodType.B; break;
            case "O": bt = BloodType.O; break;
        }
        return bt;
    }

    private static String[] resetHobbies() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 취미의 개수를 입력하세요(1개 이상): ");
        int length = sc.nextInt();
        sc.nextLine();

        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.print((i + 1) + "번째 취미를 입력하세요: ");
            String input = sc.nextLine();
            hobbies[i] = input;
        }
        return hobbies;
    }

    /* 설명. 회원 가입 페이지 */
    private static Member singUp() {        // 회원가입 입력 받기
        Member member = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();

        System.out.print("패스워드를 입력하세요: ");
        String pwd = sc.nextLine();

        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();

        System.out.print("입력할 취미의 갯수를 입력하세요(1개 이상): ");
        int length = sc.nextInt();
        sc.nextLine();      // 버퍼에 남은 엔터 제거용

        String[] hobbies = new String[length];
        for (int i = 0; i < hobbies.length; i++) {
            System.out.print((i + 1) + "번째 취미를 입력하세요: ");
            String input = sc.nextLine();
            hobbies[i] = input;
        }

        System.out.print("혈액형을 입력하세요(A, AB, B, O): ");
        String bloodType = sc.nextLine().toUpperCase();     // 대문자로 출력
        BloodType bt = null;
        switch (bloodType) {
            case "A": bt = BloodType.A; break;
            case "AB": bt = BloodType.AB; break;
            case "B": bt = BloodType.B; break;
            case "O": bt = BloodType.O; break;
        }

        member = new Member(id, pwd, age, hobbies, bt);

        return member;
    }

    /* 설명. 회원번호를 입력 받아 int로 반환하는 메소드 */
    private static int chooseMemNo() {              // 회원번호 입력 받기
        Scanner sc = new Scanner(System.in);
        System.out.print("회원번호를 입력하세요: ");
        return sc.nextInt();
    }
}