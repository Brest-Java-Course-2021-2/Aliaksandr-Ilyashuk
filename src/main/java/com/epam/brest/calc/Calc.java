package com.epam.brest.calc;

import java.math.BigDecimal;

public interface Calc {
double d1 = 0.0f;
Double d3 = 0.0f;
Double d5 = 0.d;
Double d6 = 1L;

double d2 = new Double(.0f);
Double d4 = new Double("1L");

    BigDecimal handle(BigDecimal weight, BigDecimal pricePerKg, BigDecimal length, BigDecimal pricePerKm);
}
