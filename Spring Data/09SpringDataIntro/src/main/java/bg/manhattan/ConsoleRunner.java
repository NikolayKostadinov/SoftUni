package example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) {
        System.out.println("Started!!!");
    }
}

