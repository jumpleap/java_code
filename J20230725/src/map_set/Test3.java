package map_set;

public class Test3 {
    public static void main(String[] args) {
        HashBucketComplex<Person, String> s = new HashBucketComplex<>();
        Person person1 = new Person("123");
        Person person2 = new Person("123");

        s.put(person1,"zhagnsan");

        System.out.println(s.get(person2));
    }
}