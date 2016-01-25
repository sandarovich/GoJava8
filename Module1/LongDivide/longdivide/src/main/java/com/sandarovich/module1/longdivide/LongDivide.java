package com.sandarovich.module1.longdivide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Olexander Kolodiazhny
 * 
 *  Module #1. Task #4 Column Divide algorithm with text output.
 *
 */
public class LongDivide {
	private static final String COLUMN_DIVIDER = "|";
	private static final String OPERATION_DIVIDER = "---";
	private static final String OPERATION_MINUS = "-";
	private static final String BRACKET_LEFT = "(";
	private static final String BRACKET_RIGHT = ")";
	private static final int DIVIDE_DEPTH = 10;
	private static final int INDEPTH_MULTIPLYER = 10;
	
	private int dividen;
	private int divider;
	private int remain;
	private StringBuilder result;
	
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
	
	public void readNumbers() {
		while (!parseInput(readFromKeyboard())) {
			System.out.println("\nWARNING!. Input is incorrect. Please try again.\n");
		}
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
			return true;
		}
	}
	
}
