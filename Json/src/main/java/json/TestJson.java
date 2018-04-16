package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJson {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Person person = (Person) context.getBean("person");
        String gsonPerson = gson.toJson(person);
        System.out.println(gsonPerson);
        Person person1 = gson.fromJson(gsonPerson, Person.class);
        System.out.println(person1.getName());
    }
}
