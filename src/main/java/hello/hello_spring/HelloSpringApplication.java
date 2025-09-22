package hello.hello_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class HelloSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);
    }

    public void add(){
        Scanner sc = new Scanner(System.in);
        Integer k  = sc.nextInt();
        String ks = sc.next();

    }

}
