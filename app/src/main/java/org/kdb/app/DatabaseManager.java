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
    private File file;
    private String path;

    /**
     * @param path the path to the database
     */
    public DatabaseManager(String path)
    {
        System.out.println("Opening database at: " + path);
        this.file = new File(path);
        this.path = path;
        
        if (this.file.exists())
        {
            System.out.println("Database \"" + path + "\" already exists.");
        } else
        {
            System.out.println("Database \"" + path + "\" does not already exist.");

            System.out.println("Creating database directory at: " + path);
            if (this.file.mkdirs())
            {
                System.out.println("Directory created: " + this.file.getAbsolutePath());
            } else
            {
                System.out.println("Failed to create directory: " + this.file.getAbsolutePath());
            }
        }
    }
    
    /**
     * @return directory file for database
     */
    public File getFile() { return this.file; }

    /**
     * @return path to directory file for database
     */
    public String getPath() { return this.path; }
}
