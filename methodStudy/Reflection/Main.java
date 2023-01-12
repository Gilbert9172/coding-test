package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
//        Class<Member> memberClass = Member.class;
//        System.out.println(System.identityHashCode(memberClass));
//
//        Member member = new Member("제이온", 23, "다라쓰 개발");
//        Class<? extends Member> memberClass2 = member.getClass();
//        System.out.println(System.identityHashCode(memberClass2));
//
//        Class<?> memberClass3 = Class.forName("Reflection.Member");
//        System.out.println(System.identityHashCode(memberClass3));
//    }

//        // Member의 모든 생성자 출력
//        Member member = new Member();
//        Class<? extends Member> memberClass = member.getClass();
//        Arrays.stream(memberClass.getConstructors()).forEach(System.out::println);
//        System.out.println("===");
//
//        // Member의 기본 생성자를 통한 인스턴스 생성
//        Constructor<? extends Member> constructor = memberClass.getConstructor();
//        Member member2 = constructor.newInstance();
//        System.out.println("member2 = " + member2);
//        System.out.println("===");
//
//        // Member의 다른 생성자를 통한 인스턴스 생성
//        Constructor<? extends Member> fullConstructor =
//                memberClass.getConstructor(String.class, int.class, String.class);
//        Member member3 = fullConstructor.newInstance("제이온", 23, "다라쓰 개발");
//        System.out.println("member3 = " + member3);
//        System.out.println("===");
//    }

        Member member = new Member("제이온", 23, "다라쓰 개발");
        Class<? extends Member> memberClass = member.getClass();

        // 필드 접근
        Field[] fields = memberClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.get(member));
        }
        fields[0].set(member, "제이온2");
        System.out.println(member);

        // 메소드 접근
        Method speakMethod = memberClass.getDeclaredMethod("speak", String.class);
        speakMethod.invoke(member, "리플렉션 테스트");

        Method secretMethod = memberClass.getDeclaredMethod("secret");
        secretMethod.setAccessible(true);
        secretMethod.invoke(member);
    }

}

class Member {

    private String name;

    protected int age;

    public String hobby;

    public Member() {
    }

    public Member(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public void speak(String message) {
        System.out.println(message);
    }

    private void secret() {
        System.out.println("비밀번호는 1234입니다.");
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
