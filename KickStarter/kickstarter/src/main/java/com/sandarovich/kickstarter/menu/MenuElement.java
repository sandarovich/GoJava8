package com.sandarovich.kickstarter.menu;

/**
 * @author Olexander Kolodiazhny 2016
 *      Describe Every Menu element
 */

public class MenuElement {
    
    private String nameLabel;
    private int id;
    
    public String getNameLabel() {
        return nameLabel;
    }

    public int getId() {
        return id;
    }
       
    public MenuElement(String nameLabel, int id) {
        this.nameLabel = nameLabel;
        this.id = id;
    }

    @Override
    public String toString() {
        String result =  id + " -  " + nameLabel;
        return result;
    }
    
    
}
