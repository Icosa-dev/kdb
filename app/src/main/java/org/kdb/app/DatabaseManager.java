/*
 * Copyright (c) 2025 LJC
 * 
 * SPDX-License-Identifier: BSD-2-Clause
 */

/*
 * The DatabaseManager will manage every document
 * for a given database.
 */

package org.kdb.app;

import java.io.File;

public class DatabaseManager 
{
    private File dbPath;

    /**
     * @param path the path to the database
     */
    public DatabaseManager(String path)
    {
        System.out.println("Opening database at: " + path);
        this.dbPath = new File(path);
        
        if (this.dbPath.exists())
        {
            System.out.println("Database \"" + path + "\" already exists.");
        } else
        {
            System.out.println("Database \"" + path + "\" does not already exist.");

            System.out.println("Creating database directory at: " + path);
            if (this.dbPath.mkdirs())
            {
                System.out.println("Directory created: " + this.dbPath.getAbsolutePath());
            } else
            {
                System.out.println("Failed to create directory: " + this.dbPath.getAbsolutePath());
            }
        }
    }        
}
