package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.Categories;
import com.sandarovich.kickstarter.Output;
import com.sandarovich.kickstarter.Project;
import com.sandarovich.kickstarter.Projects;

/**
 * @author Olexamder Kolodiazhny 2016
 *
 */

public class ProjectMenu extends AbstractMenu {

	public ProjectMenu(Output output, MenuReader menuReader, Categories category) {
		super(output, menuReader);
		menuId = 3;
		headerLabel = "Projects:";

		Project[] projects = new Projects().getByCategory(category);
		int projectCount = projects.length;
		menuElements = new MenuElement[projectCount + 1];
		if (projectCount != 0) {
			for (int index = 0; index < projects.length; index++) {
				menuElements[index] = new MenuElement(projects[index].getShortDescription(), 
						Actions.SHOW_PROJECT,index);
			}
		}
		menuElements[projectCount] = new MenuElement("Exit", Actions.EXIT, projectCount);

	}

	@Override
	public void doAction(int choise) {
		// TODO Auto-generated method stub

	}

}
