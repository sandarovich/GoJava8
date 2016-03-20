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
            throw new IllegalStateException("Environment variable" + daoMode + " was not found");
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
