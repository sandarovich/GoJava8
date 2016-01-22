package com.sandarovich.module1.findistance;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Olexander Kolodiazhny 2016
 * 
 * Custom Array List for task #2.
 *
 */

public class MyArray {
	
	private ArrayList<Integer> array;
	private ArrayList<Integer> sortedArray;
	
	MyArray(int[] array) {
		this.array = new ArrayList<Integer>();
		for (int i: array) {
			this.array.add(i);
		}
		this.sortedArray = new ArrayList<Integer>(this.array);
	}
	
	private void sort() {
		Collections.sort(this.sortedArray);

	}
		
	
	private int getElementCount(int element) {
		 if (this.array.contains(element) ) {
			 return Collections.frequency(this.array, element);
		 }
		 return 0;
	}
	
	private int getElementIndex(int element) {
		return this.array.indexOf(element);
	}
	
	private ArrayList<Integer> getDublikatElementIndex(int firstMin) {
		
		ArrayList<Integer>indexesOfMin = new ArrayList<Integer>();
		
		for (int i = 0; i < this.array.size(); i++) {
			if (this.array.get(i) == firstMin) {
				indexesOfMin.add(i);
			}
		}
		
		return indexesOfMin;
	}
	
	private int getDistanceBetweenTwoElement(int firstMin, int secondMin) {
		return Math.abs(getElementIndex(firstMin) - getElementIndex(secondMin));
	}
	
	private String getDistanceBetweenSameElement(int firstMin) {
		//TODO To write algorith to search distances
		ArrayList<Integer> out = new ArrayList<>();
		ArrayList<Integer> indexesOfMin = getDublikatElementIndex(firstMin);
		
		for (int i = 0; i < indexesOfMin.size(); i++) {
			
		}
	
		return out;
	}
	//TODO O.Kolodiazhny. MAYBE PATTERN STRATEGY??? Not sure. 
	public String getDistance() {
		this.sort();
		if (getElementCount(sortedArray.get(0)) > 2) {
			return getDistanceBetweenSameElement(sortedArray.get(0));
		} else if (sortedArray.get(0) == 1) {
			return Integer.toString(getDistanceBetweenTwoElement(sortedArray.get(0), sortedArray.get(1)));
		} else return "";
	}
}
