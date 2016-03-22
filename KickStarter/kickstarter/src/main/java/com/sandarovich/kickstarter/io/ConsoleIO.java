package com.sandarovich.kickstarter.io;

import com.sandarovich.kickstarter.dao.category.Project;
import dnl.utils.text.table.TextTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *        Output\Read text to user console
 *
 */

public class ConsoleIO implements IO {

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public String read() {
        String resultStr = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            resultStr = reader.readLine();
        } catch (IOException e) {
            new ConsoleIO().write(">> Exception.Unable to read input");
        }
        return resultStr;
    }

    @Override
    public void writeProjectsAsTable(List<Project> object) {
        ProjectTableView projectTableView = new ProjectTableView(object);
        TextTable textTable = new TextTable(projectTableView.getColumnNames(), projectTableView.getData());
        textTable.printTable();
    }

}
