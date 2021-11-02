package com.epam.brest.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import static com.epam.brest.model.StatusType.*;

public class ReadDataState extends AbstractStatus {



  public ReadDataState(Scanner scanner, Map<Integer, BigDecimal> pricePerKgMap, Map<Integer, BigDecimal> pricePerKmMap) {
    this.scanner = scanner;
    this.pricePerKgMap = pricePerKgMap;
    this.pricePerKmMap = pricePerKmMap;
  }


  @Override
    public Status handle() {
        if (userData.size() < 2) {
            System.out.println(messages.get(userData.size()));
            String inputValue = scanner.next();
            if (inputValue.equalsIgnoreCase("q")) {
                return new ExitState();
            } else if (isCorrectValue(inputValue)) {
                userData.add(new BigDecimal(inputValue));
            }
        } else {
            return new CalcState(scanner,pricePerKgMap, pricePerKmMap);
        }

        return this;
    }

    private boolean isCorrectValue(String inputValue) {
        try {
            BigDecimal enteredValue = new BigDecimal(inputValue);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Incorrect value" + inputValue);
        }
        return false;

    }

    @Override
    public StatusType getType() {
        return READ_DATA;
    }
}
