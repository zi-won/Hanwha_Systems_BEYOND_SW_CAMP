package com.ohgiraffers.section04.testapp.repository;

import com.ohgiraffers.section04.testapp.aggregate.AccountStatus;
import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

/* 설명. 데이터베이스 개념(Member 관련 파일)과 입출력(CRUD)을 위해 만들어지며
    성공데이터 또는 성공/실패 여부를 반환(java의 컬렉션 개념으로 데이터를 관리하기도 한다.) */
public class MemberRepository {

    /* 설명. 초기에 Member 파일이 없다면 파일을 만들어 더미데이터(dummy data)를 쌓는다. */
    private final ArrayList<Member> memberList = new ArrayList<>();     // 회원정보를 저장하는 ArrayList
    private final File file =   // 회원정보가 저장되는 파일 경로로 이 파일에 회원 데이터를 저장한다.
            new File("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat");

    /* 설명. 프로그램 구동시 MemberRepository 생성자가 호출되며 초기에 실행할 내용들 */
    public MemberRepository() {
        // 파일이 없으면 기본 회원 데이터를 생성하여 파일에 저장하고, 파일이 있으면 loadMemebers()를 로드한다.
        if (!file.exists()) {
            ArrayList<Member> defaultMembers = new ArrayList<>();
            defaultMembers.add(new Member(1, "user01", "pass01", 20,
                    new String[]{"발레", "수영"}, BloodType.A, AccountStatus.ACTIVE));
            defaultMembers.add(new Member(2, "user02", "pass02", 10,
                    new String[]{"게임", "영화시청"}, BloodType.B, AccountStatus.ACTIVE));
            defaultMembers.add(new Member(3, "user03", "pass03", 30,
                    new String[]{"음악감상", "독서", "명상"}, BloodType.AB, AccountStatus.ACTIVE));

            saveMembers(defaultMembers);    // ObjectOutputStream을 사용하여 회원 데이터를 파일에 저장한다.
        }

        loadMembers();  // ObjectInputStream을 사용하여 파일에서 회원 데이터를 읽어온다.
    }

    /* 설명. 파일로부터 회원 객체들을 읽어와서 memberList 컬렉션에 저장 */
    private void loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream( // 파일에 저장된 데이터를 다시 읽어옴
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        )) {
            while (true) {
                memberList.add((Member)ois.readObject());
            }

        } catch (EOFException e) {
            System.out.println("회원 정보 다 읽어옴");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /* 설명. ArrayList<Member>를 받으면 파일로 출력하는 메소드(feat. 덮어씌우는 기능) */
    private void saveMembers(ArrayList<Member> inputMembers) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(   // 객체에 있는 데이터를 파일에 저장함
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    )
            );

            for (Member member : inputMembers) {
                oos.writeObject(member);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Member> selectAllMembers() {   // 모든 회원을 반환한다.
        return memberList;
    }

    public Member selectMemberBy(int memNo) { // 특정 회원 번호에 해당하는 회원을 반환하고, 없으면 null을 반환한다.
        Member returnMember = null;

        for (Member member : memberList) {
            if (member.getMemNo() == memNo) {
                returnMember = member;
            }
        }

        return returnMember;
    }

    public int selectLastMemberNo() {
        Member lastMember = memberList.get(memberList.size() - 1);      // 마지막 회원의 번호 가져오기
        return lastMember.getMemNo();
    }

    public int insertMember(Member member) {

        /* 설명. 헤더가 추가되지 않는 ObjectOutputStream 클래스 정의(MyObjectOutputStream) */
        MyObjectOutput moo = null;
        int result = 0;

        try {
            moo = new MyObjectOutput(
                    new BufferedOutputStream(
                            new FileOutputStream(file, true)    // true를 해줌으로써 이어붙이기 가능
                    )
            );

            /* 설명. 파일로 신규회원 추가하기 */
            moo.writeObject(member);

            /* 설명. 컬렉션에도 신규회원 추가하기
                (MyObjectOutputStream으로 이어붙인 정보는 다시 입력 받아도 이전 파일로 인식함 ]
                (프로그램을 껏다 켜면 다시 재인식이 되긴 함)
             */
            memberList.add(member);

            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result;      // 0 또는 1(성공 시 1)
    }

    /* 설명. 수정된 사본이 넘어오면 컬렉션에 담긴 동일한 회원을 update하고 컬렉션의 회원 정보로 파일을 덮어씌운다. */
    public int updateMember(Member reformedMember) {
        for (int i = 0; i < memberList.size(); i++) {
            if(memberList.get(i).getMemNo() == reformedMember.getMemNo()) {
                memberList.set(i, reformedMember);      // 컬렉션 업데이트
                saveMembers(memberList);                // 파일 업데이트(덮어씌우기)

                return 1;
            }
        }
        return 0;
    }

    /* 설명. soft delete(일종의 업데이트)를 통해 회원 탈퇴를 구성 */
    public int deleteMember(int removeMemNO) {
        int result = 0;

        for (Member mem : memberList) {
            if (mem.getMemNo() == removeMemNO) {
                mem.setAccountStatus(AccountStatus.DEACTIVATED);
                result = 1;
                saveMembers(memberList);        // 쿼리가 없기 때문에 덮어씌우기
            }
        }
        return result;
    }
}