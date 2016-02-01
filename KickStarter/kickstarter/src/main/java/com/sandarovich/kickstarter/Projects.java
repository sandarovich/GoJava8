package com.sandarovich.kickstarter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olexamder Kolodiazhny 2016
 *
 *	Class for soring Projects
 */

public class Projects {
	
	private List<Project> projectList;
	
	public Projects() {
		projectList = new ArrayList<Project>();
		projectList.add(new Project.Builder(1,Categories.IT)
						.description("USB Lighter   ")
		        		.shortDescription("Lighter")
		        		.goalAmount(7000)
		        		.collectedAmount(100)	
						.build()
					);
		projectList.add(new Project.Builder(2,Categories.IT)
				.description("USB Toy & Joy ")
        		.shortDescription("Toy     ")
        		.goalAmount(100)
        		.collectedAmount(300)	
				.build()
			);
		projectList.add(new Project.Builder(3,Categories.IT)
				.description("Smart Keyboard")
        		.shortDescription("Keyboard")
        		.goalAmount(700)
        		.collectedAmount(200)	
				.build()
			);
		projectList.add(new Project.Builder(4,Categories.ECOLOGY)
				.description("Water waste device")
        		.shortDescription("Water waste device")
        		.goalAmount(500)
        		.collectedAmount(5)	
				.build()
			);
		projectList.add(new Project.Builder(4,Categories.ECOLOGY)
				.description("Heat waste device")
        		.shortDescription("Heat  waste device")
        		.goalAmount(700)
        		.collectedAmount(1)	
				.build()
			);
		projectList.add(new Project.Builder(5,Categories.SPORT)
				.description("Football shoes")
        		.shortDescription("Sportswear")
        		.goalAmount(900)
        		.collectedAmount(950)	
				.build()
			);
		projectList.add(new Project.Builder(5, Categories.SPORT)
				.description("Basketball shoes")
        		.shortDescription("Sportswear")
        		.goalAmount(1000)
        		.collectedAmount(850)	
				.build()
			);
		
		projectList.add(new Project.Builder(5, Categories.SOCIETY)
				.description("Positive poems")
        		.shortDescription("Poems")
        		.goalAmount(300)
        		.collectedAmount(450)	
				.build()
			);
		
	}
	
	public Project[] getByCategory(Categories category) {
		ArrayList<Project> result = new ArrayList<Project>();
	
		for (int index = 0; index < projectList.size(); index++) {
			if (projectList.get(index).getCategory() == category) {
				result.add(projectList.get(index));
			}
		}
		return result.toArray(new Project[result.size()]);
		
	}
	
}
