package json;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<String> cityes;

    public Person(String name, int age, List<String> cityes) {
        this.name = name;
        this.age = age;
        this.cityes = cityes;
    }

    @Override
    public String toString() {
        return "json.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cityes=" + cityes +
                '}';
    }

    String getName() {
        return name;
    }
}


