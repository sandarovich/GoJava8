package com.sandarovich.module1.columndivision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Olexander Kolodiazhny
 * 
 *         Module #1. Task #4 Column Divide algorithm with text output.
 *
 */

public class ColumnDivision {

    private static final int DIVIDE_DEPTH = 6;
    private static final int GUESS_LIMIT = 10;
    private static final int MULTIPLYER = 10;

    private int dividen;
    private int divider;
    private double result = 0;
    private int remain = -1;
    private int diff;
    private int firstDiff;
    private int depth = 0;
    List<String> resultStr;

    public void readNumbers() {
        while (!parseInput(readFromKeyboard())) {
            System.out.println("\nWARNING!. Input is incorrect. Please try again.\n");
        }
    }

    private String readFromKeyboard() {
        System.out.println("Please enter input. Example \"12/42\"");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = null;
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            inputString = "-1";
        }
        return inputString;
    }

    private boolean parseInput(String inputString) {
        if (inputString == null || inputString.equals("-1")) {
            return false;
        } else {
            String[] numbers = inputString.split(Strings.DIVIDER.toString());
            try {
                dividen = Integer.parseInt(numbers[0]);
                divider = Integer.parseInt(numbers[1]);
            } catch (Exception e) {
                return false;
            }
            System.out.println(">> Input parsed Successfully<<");
            return true;
        }
    }

    public void showResult() {

        resultStr = new ArrayList<String>();
        resultStr.add(Strings.OPERATION_MINUS.toString() + dividen 
                + Strings.SPACE.toString() + Strings.COLUMN_DIVIDER.toString() + divider);
        calcRemain(dividen, divider);
        resultStr.add(1, Strings.TAB.toString() + this.firstDiff + Strings.COLUMN_DIVIDER.toString() + formatResult(this.result));
        resultStr.add(StringUtils.repeat(Strings.TAB.toString(), depth) + Strings.OPERATION_DIVIDER.toString());
        resultStr.add(StringUtils.repeat(Strings.TAB.toString(), depth) + String.valueOf(this.remain));

        System.out.println("Results: ");
        for (String line : resultStr) {
            System.out.println(line);
        }
    }

    private String formatResult(double result) {
        String format = "%." + String.valueOf(DIVIDE_DEPTH) + "f";
        if (remain != 0 && depth == DIVIDE_DEPTH) {
            String out = String.format(format, result);
            out = out.substring(0, out.indexOf(".") + 1) + Strings.BRACKET_LEFT.toString()
                    + out.substring(out.indexOf(".") + 1, out.length()) + Strings.BRACKET_RIGHT.toString();
            return out;
        }
        return String.format(format, result);

    }

    private double calcRemain(double dividen, double divider) {

        boolean ignoreOperation = false;
        if (remain == 0 || depth >= DIVIDE_DEPTH) {
            return remain;
        } else {
            if (dividen <= divider) {
                dividen = dividen * MULTIPLYER;
                depth++;
            } else {
                firstDiff = (int) divider * findGuessCoef(dividen, divider);
            }
            int multipl = findGuessCoef(dividen, divider);
            result += multipl / (Math.pow(MULTIPLYER, depth));
            this.diff = (int) (divider * multipl);
            if (depth == 1 && firstDiff == 0) {
                this.firstDiff = diff;
                ignoreOperation = true;
            }
            remain = (int) (dividen - divider * multipl);
            this.dividen = remain;

            if (!ignoreOperation) {
                resultStr.add(StringUtils.repeat(Strings.TAB.toString(), depth) + Strings.OPERATION_DIVIDER.toString());
                resultStr.add(StringUtils.repeat(Strings.TAB.toString(), depth) + Strings.SPACE.toString() + (int) dividen);
                resultStr.add(StringUtils.repeat(Strings.TAB.toString(), depth) + Strings.OPERATION_MINUS.toString() + diff);
            }
            ignoreOperation = false;

            return calcRemain(this.dividen, this.divider);
        }
    }

    private int findGuessCoef(double dividen, double divider) {
        int result = 0;

        for (int i = GUESS_LIMIT; i >= 1; i--) {
            if (divider * i <= dividen) {
                result = i;
                break;

            }
        }
        return result;
    }

}
