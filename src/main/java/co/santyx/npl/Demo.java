package co.santyx.npl;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Demo {
    public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }
}

@RestController
class NPLController {

    @GetMapping("/")
    public String hello() {
        return "Hello, Puzzler!";
    }

    @GetMapping("/v1/letter-bank")
    public String letterBank(@RequestParam String q) {

        String out = unique(q).toString();

        return "letter-bank -> " + q + " -> " + out;
    }

    private String unique(String in) {
        int[] mask = new int[256];
        StringBuilder sb = new StringBuilder(in.length());

        for (char c : in.toCharArray()) {
            if (mask[c] == 0) {
                sb.append(c);
            }

            mask[c]++;
        }
        return sb.toString();

    }

}