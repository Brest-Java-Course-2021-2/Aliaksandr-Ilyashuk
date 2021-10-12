package com.epam.brest;

import com.epam.brest.calc.Calc;
import com.epam.brest.calc.CalcImpl;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello world");
//
//        float f1 = 8.4f;
//        float f2 = 100f;
//        float f = f1 * f2;
//        System.out.println(f);
//
        //result = m * pricePerKg + km * pricePerKm
        BigDecimal weight, pricePerKg, length, pricePerKm;

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                try {

                    weight = getValueFromCon(scanner, "Enter weight: ");
                    pricePerKg = getValueFromCon(scanner, "Enter pricePerKg: ");
                    length = getValueFromCon(scanner, "Enter length: ");
                    pricePerKm = getValueFromCon(scanner, "Enter pricePerKm: ");

                    System.out.println("result: " + new CalcImpl().handle(weight, pricePerKg, length, pricePerKm));
                } catch (InputMismatchException ime) {
                    System.out.println(ime + "\n" + "Program is stop");
                    return;
                }
            }
        }
    }

    private static BigDecimal getValueFromCon(Scanner scanner, String outputMessage) {
        BigDecimal value;
        System.out.print(outputMessage);
        value = scanner.nextBigDecimal();
        return value;
    }
}
