package hello;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
@EnableAutoConfiguration
public class Application {
    static List<Galant> galants = new ArrayList<>();
    static Galant galant = new Galant("Mitsubisi", "4G63T");
    static Galant galant1 = new Galant("Mitsubishi", "6A13TT");
    static public void addGalant(){
        galants.add(galant);
        galants.add(galant1);
    }

    public static void main(String[] args) {
        addGalant();
        SpringApplication.run(Application.class, args);
    }

}