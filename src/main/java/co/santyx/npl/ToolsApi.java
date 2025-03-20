// filepath: /c:/Users/synt_/OneDrive/Dev/npl/src/main/java/co/santyx/npl/ToolsApi.java
package co.santyx.npl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
class ToolsApi {
    public static void main(String[] args) {
        SpringApplication.run(ToolsApi.class, args);
    }

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/")
    public String hello() {
        return "Hello, Puzzler!";
    }

//    @GetMapping("/v1/letter-bank")
//    public String apiLetterBank(@RequestParam("q") String q) {
//        String out = unique(q).toString();
//        return "letter-bank -> " + q + " -> " + out;
//    }
//
//    @GetMapping("/v1/sort")
//    public String apiSort(@RequestParam("q") String q) {
//        String out = sort(q).toString();
//        return "sort -> " + q + " -> " + out;
//    }

    @GetMapping("/v1/dictionary")
    public String apiWordMatch(@RequestParam("q") String q, @RequestParam("l") Integer l) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:wordlists/xwordlist.dict");
        InputStream resourceInputStream = resource.getInputStream();

        Scanner sc = new Scanner(resourceInputStream, StandardCharsets.UTF_8);
        String query = ".*"+q.toUpperCase()+".*";

        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.length() == l) {
                if (line.matches(query)) {
                    sb.append(line).append(",");
                }
            }
        }

        return sb.toString();
    }

//    private String sort(String in) {
//        return Stream.of(in.split(""))
//                .sorted()
//                .collect(Collectors.joining());
//    }
//
//    private String unique(String in) {
//        int[] mask = new int[256];
//        StringBuilder sb = new StringBuilder(in.length());
//
//        for (char c : in.toCharArray()) {
//            if (mask[c] == 0) {
//                sb.append(c);
//            }
//            mask[c]++;
//        }
//        return sb.toString();
//    }
}