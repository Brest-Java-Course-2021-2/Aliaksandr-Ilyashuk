package com.epam.brest;

import com.epam.brest.calc.CalcImpl;
import com.epam.brest.model.ReadData;
import com.epam.brest.model.Status;
import com.epam.brest.model.StatusType;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in)) {

            Status currentStatus = new ReadData(scanner);
            while (currentStatus.getType() != StatusType.EXIT) {
                System.out.println("currentStatus " + currentStatus.getType());
                currentStatus = currentStatus.handle();
            }
        }
    }


}
