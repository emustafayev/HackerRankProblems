package spring.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.example.annotations.Traceable;
import spring.example.models.Animals;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    @GetMapping
    @Traceable
    public List<Animals> getData(@RequestParam String requestNum, HttpServletRequest servletRequest) {

        return Arrays.asList(new Animals("Katya", "dog"),
                new Animals("Nebula", "dog"),
                new Animals("Nova", "dog"));
    }
}
