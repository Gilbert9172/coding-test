package comparable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSort {

    public static void main(String[] args) {
        List<Member> memberList = Arrays.asList(
                new Member("이산", 22),
                new Member("진영", 23),
                new Member("별찬", 20)
        );

        Stream<Member> stream = memberList.stream();
        stream.sorted((m1, m2) -> m1.getAge() - m2.getAge())
                .forEach(m -> System.out.println(m.getName()));

    }

    public static class Member {
        private String name;
        private Integer age;

        public Member(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public Integer getAge() {
            return this.age;
        }

    }
}

