package com.sandarovich.kickstarter.menu;

/**
 * @author Olexander Kolodiazhny 2016
 *      Describe Every Menu element
 */

public class MenuElement {
    
    private String nameLabel;
    
    public MenuElement(String nameLabel) {
        this.nameLabel = nameLabel;
    }

    @Override
    public String toString() {
        return nameLabel;
    }
    
    
}
