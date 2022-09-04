package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {

    public static void main(String[] args) {

        List<User> userList = addDummyDate();

        userList.stream()
                .map(o -> o.getAge())
                .filter(age -> age > 30)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static class User {

        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }

    public static List<User> addDummyDate() {
        User user1 = new User("gilbert1", 28);
        User user2 = new User("gilbert2", 48);
        User user3 = new User("gilbert3", 18);
        User user4 = new User("gilbert4", 25);
        User user5 = new User("gilbert5", 33);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        return userList;
    }

}
