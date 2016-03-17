package com.sandarovich.kickstarter;

/**
 * Application mode enum
 */

public enum DaoMode {
    MEMORY,
    FILE,
    DB;

    public static DaoMode fromName(String daoMode) {
        if (daoMode == null) {
            return MEMORY;
        }
        daoMode = daoMode.toUpperCase().trim();
        if (daoMode.equals(DaoMode.FILE.toString())) {
            return FILE;
        }
        if (daoMode.equals(DaoMode.DB.toString())) {
            return DB;
        }
        return MEMORY;
    }
}
