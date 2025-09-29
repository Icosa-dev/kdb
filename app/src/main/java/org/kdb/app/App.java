/*
 * Copyright (c) 2025 LJC
 * 
 * SPDX-License-Identifier: BSD-2-Clause
 */

package org.kdb.app;

public class App
{
    public static void main(String[] args) 
    {
        System.out.println("KDB version INDEV");
        
        DatabaseManager databaseManager = new DatabaseManager("D:/Programming/kdb/testdb");
    }
}