package org.example;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculatorController {


        @GetMapping("/add")
        public int add(@RequestParam int a, @RequestParam int b) {

            return a + b;
        }

        @GetMapping("/subtract")
        public int subtract(@RequestParam int a, @RequestParam int b) {
            return a - b;
        }

        @GetMapping("/multiply")
        public int multiply(@RequestParam int a, @RequestParam int b) {
            return a * b;
        }

        @GetMapping("/divide")
        public double divide(@RequestParam double a, @RequestParam double b) {
            if (b == 0) throw new IllegalArgumentException("Cannot divide by zero");
            return a / b;
        }
    }


