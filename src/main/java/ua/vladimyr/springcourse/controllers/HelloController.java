package ua.vladimyr.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;




@Controller
public class HelloController {

    @GetMapping("/hello-world")

    public String helloPage(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, Model model) {


        //System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);


        return "first/hello_world";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a") int a,
                                 @RequestParam(value = "b") int b,
                                 @RequestParam(value = "action") String action,
                                 Model model) {


        double result = 0;
        if (action.equals("divide")) {
            result = a / (double) b;
        } else if (action.equals("multiply")) {
            result = a * b;
        } else if (action.equals("addition")) {
            result = a + b;
        } else if (action.equals("subtraction")) {
            result = a - b;
        }

        model.addAttribute("result", "Hello, motherfucker result is: " + result);


        return "second/result_page";
    }
}
