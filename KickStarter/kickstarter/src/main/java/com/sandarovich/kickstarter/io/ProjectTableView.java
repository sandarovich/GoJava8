package com.sandarovich.kickstarter.io;

import com.sandarovich.kickstarter.dao.category.Project;

import java.util.List;
import java.util.Map;

/**
 * @author Olexander Kolodiazhny 2016
 */

class ProjectTableView {

    private final String[] columnNames;
    private final Object[][] data;

    public ProjectTableView(List<Project> projects) {
        columnNames = generateColumnNames();
        data = generateData(projects);
    }

    private String[] generateColumnNames() {
        String[] result = {"Id", "Name", "Short Desription",
                "Required Budget", "Gathered Budget", "Days left"};
        return result;
    }

    private Object[][] generateData(List<Project> projects) {
        Object[][] result = new Object[projects.size()][columnNames.length];
        for (int rowIndex = 0; rowIndex < projects.size(); rowIndex++) {
            Map<String, Object> row = object.getRowData(rowIndex);
            int columnIndex = 0;
            for (Map.Entry<String, Object> pair : row.entrySet()) {
                result[rowIndex][columnIndex++] = pair.getValue();
            }
        }
        return result;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public Object[][] getData() {
        return data;
    }
}
