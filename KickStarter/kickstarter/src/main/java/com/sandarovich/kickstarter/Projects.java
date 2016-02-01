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
						.description("USB Lighter")
		        		.shortDescription("Lighter")
		        		.goalAmount(10000)
		        		.collectedAmount(200)	
						.build()
					);
		projectList.add(new Project.Builder(2,Categories.IT)
				.description("USB Toy")
        		.shortDescription("Toy")
        		.goalAmount(100)
        		.collectedAmount(200)	
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
	
	
//	public void show(Categories category) {
//		ArrayList<Project> projects = getProjects(category);
//		for (int index = 0; index < projects.size(); index++) {
//			projects.get(index).toString();
//		}
//	}
}
