package com.sandarovich.kickstarter.dao;

/**
 * Application mode enum
 */

public enum DaoMode {
    MEMORY,
    FILE,
    DB;

    public static DaoMode fromName(String daoMode) {
        if (daoMode == null || daoMode.isEmpty()) {
            //-Dmode=memory
            throw new IllegalStateException("Environment variable mode was not found" +
                    " --> To Fix use: -Dmode=memory)");
        }
        daoMode = daoMode.toUpperCase().trim();
        if (FILE.toString().equals(daoMode)) {
            return FILE;
        }
        if (DB.toString().equals(daoMode)) {
            return DB;
        }
        return MEMORY;
    }

}
