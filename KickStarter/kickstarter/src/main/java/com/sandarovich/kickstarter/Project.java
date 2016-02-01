package com.sandarovich.kickstarter;

import java.util.Date;

/**
 * @author Olexamder Kolodiazhny 2016 Describes Project entitity.
 * 	 Builder pattern  used.
 */

public class Project {

	private final int id;
	private final Categories category;
	private final String description;
	private final String shortDesription;
	private final double goalAmount;
	private final double collectedAmount;
	private final Date goalDate;
	private final String videoLink;
	private final String history;
	private final String questionsAnswers;

	public static class Builder {
		// Required fields
		private final int id;
		private final Categories category;
		
		// Optional fields
		private String description = "";
		private String shortDesription = "";
		private double goalAmount = 0d;
		private double collectedAmount = 0d;
		private Date goalDate = new Date();
		private String videoLink = "http:\\";
		private String history = "No history";
		private String questionsAnswers = "No Q&A";

		public Builder(int id, Categories category) {
			this.id = id;
			this.category = category;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}
	
		public Builder shortDescription(String shortDescription) {
			this.shortDesription = shortDescription;
			return this;
		}
		
		public Builder goalAmount(double goalAmount) {
			this.goalAmount = goalAmount;
			return this;
		}
		
		public Builder collectedAmount(double collectedAmount) {
			this.collectedAmount = collectedAmount;
			return this;
		}
		
		public Builder goalDate(Date goalDate) {
			this.goalDate = goalDate;
			return this;
		}
		
		public Builder videoLink(String videoLink) {
			this.videoLink = videoLink;
			return this;
		}
		
		public Builder history(String history) {
			this.history = history;
			return this;
		}
		
		public Builder questionsAnswers(String questionsAnswers) {
			this.questionsAnswers = questionsAnswers;
			return this;
		}
		
		

		public Project build() {
			return new Project(this);
		}

	}
	
	public Categories getCategory() {
		return this.category;
	}
	
	public String getShortDescription() {
		return this.shortDesription;
	}
	
	private Project(Builder builder) {
		// Required parameters
		id = builder.id;
		category = builder.category;
		// Optional parameters
		description = builder.description;
		shortDesription = builder.shortDesription;
		goalAmount = builder.goalAmount;
		collectedAmount = builder.collectedAmount;
		goalDate = builder.goalDate;
		videoLink = builder.videoLink;
		history = builder.history;
		questionsAnswers = builder.questionsAnswers;

	}

}
