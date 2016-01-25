package com.sandarovich.module1.longdivide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Olexander Kolodiazhny
 * 
 *         Module #1. Task #4 Column Divide algorithm with text output.
 *
 */
public class LongDivide {
	private static final String COLUMN_DIVIDER = "|";
	private static final String OPERATION_DIVIDER = "---";
	private static final String OPERATION_MINUS = "-";
	private static final String BRACKET_LEFT = "(";
	private static final String BRACKET_RIGHT = ")";
	private static final int DIVIDE_DEPTH = 6;
	private static final int GUESS_LIMIT = 10;
	private static final int MULTIPLYER = 10;
	private static final String TAB = "    ";

	private double dividen;
	private double divider;
	private double result = 0;
	private double remain = -1;
	private double diff = 0;
	private int depth = 0;

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
		if (inputString.equals(null) || inputString.equals("-1")) {
			return false;
		} else {
			String[] numbers = inputString.split("/");
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

		List<String> resultStr = new ArrayList<String>();
		// first line is immutable
		resultStr.add(OPERATION_MINUS + dividen + " " + COLUMN_DIVIDER + divider);


		calcRemain(dividen, divider);
		if (remain != 0) {
			
		} else {
			
		}


		System.out.println("Result: " + result);
		System.out.println("Dividen: " + dividen);
		System.out.println("Remain: " + remain);

		System.out.println("Results: ");
		for (String line : resultStr) {
			System.out.println(line);
		}
	}

	private double calcRemain(double dividen, double divider) {
		System.out.println("DD-DR " + dividen + "#" + divider);
		if (remain == 0 || depth >= DIVIDE_DEPTH) {
			return remain;
		} else {
			if (dividen <= divider) {
				dividen = dividen * MULTIPLYER;
				depth++;
			}
			double multipl = findGuessCoef(dividen, divider);
			result += multipl / (Math.pow(MULTIPLYER, depth));
			diff = divider * multipl;
			remain = dividen - divider * multipl;
			this.dividen = remain;
			System.out.println("result " + result);
			System.out.println("diff " + diff);
			return calcRemain(this.dividen, this.divider);
		}
	}

	private double findGuessCoef(double dividen, double divider) {
		int guessCoef = 0;

		for (int i = GUESS_LIMIT; i >= 1; i--) {
			if (divider * i <= dividen) {
				guessCoef = i;
				break;

			}
		}
		return guessCoef;
	}

}
