package com.example.chapter0802.controller;

import com.example.chapter0802.component.Calculator;
import com.example.chapter0802.component.ICalculator;
import com.example.chapter0802.dto.Req;
import com.example.chapter0802.dto.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorApiController {

    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y) {
        return calculator.sum(x, y);
    }

    @GetMapping("/minus")
    public int minus(@RequestParam int x, @RequestParam int y) {
        return calculator.minus(x, y);
    }


    @PostMapping("/post/sum")
    public Res sumPost(@RequestBody Req req) {
        int result = calculator.sum(req.getX(), req.getY());

        Res res = new Res();
        res.setResult(result);
        return res;
    }

    @PostMapping("/post/minus")
    public Res minusPost(@RequestBody Req req) {
        int result = calculator.minus(req.getX(), req.getY());

        Res res = new Res();
        res.setResult(result);
        res.setResponse(new Res.Body());
        return res;
    }

}
