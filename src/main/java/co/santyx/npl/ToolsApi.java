package co.santyx.npl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ToolsApi {
    public static void main(String[] args) {
        SpringApplication.run(ToolsApi.class, args);
    }
}

@RestController
class NPLController {
    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/")
    public String hello() {
        return "Hello, Puzzler!";
    }

    @GetMapping("/v1/letter-bank")
    public String apiLetterBank(@RequestParam String q) {

        String out = unique(q).toString();

        return "letter-bank -> " + q + " -> " + out;
    }

    @GetMapping("/v1/sort")
    public String apiSort(@RequestParam String q) {

        String out = sort(q).toString();

        return "sort -> " + q + " -> " + out;
    }

    @GetMapping("/v1/word-match")
    public String apiWordMatch(@RequestParam String q) throws IOException{

        // Move to service layer
        Resource resource = resourceLoader.getResource("classpath:wordlists/words_alpha.txt");
        InputStream resourceInputStream = resource.getInputStream();

        if (resourceInputStream == null) {
            throw new NullPointerException("Cannot find resource file " + resource);
        }
        
        String text = null;
        try (Scanner scanner = new Scanner(resourceInputStream, StandardCharsets.UTF_8.name())) {
            text = scanner.useDelimiter("\n").next();
            System.out.println(text);
        }

        String out = sort(q).toString();
        return "word-match -> " + q + " -> " + out;
    }

    private String sort(String in) {
        return Stream.of(in.split(""))
                .sorted()
                .collect(Collectors.joining());
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