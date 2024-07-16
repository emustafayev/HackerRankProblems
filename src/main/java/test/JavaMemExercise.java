package test;

public class JavaMemExercise {

    public static void main(String[] args) {
        Person person = new Person("Test", 23);
        System.out.println(test(person));
        System.out.println(person);
    }

    private static int test(Person person) {
        person.setAge(25);
        person = new Person("Test", 23);
        person.setName("Test2");
        return person.age;
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person name: " + this.name + ", age: " + this.age;
        }
    }
}
