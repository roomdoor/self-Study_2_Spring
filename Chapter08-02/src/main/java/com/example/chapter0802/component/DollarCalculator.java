package com.example.chapter0802.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DollarCalculator implements ICalculator {

    private int pirce = 1;
    private final MarketApi marketApi;

    @Override
    public void init() {
        this.pirce = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x *= pirce;
        y *= pirce;
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= pirce;
        y *= pirce;
        return x - y;
    }
}
