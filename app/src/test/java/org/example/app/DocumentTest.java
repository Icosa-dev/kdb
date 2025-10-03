/*
 * Copyright (c) 2025 LJC
 * 
 * SPDX-License-Identifier: BSD-2-Clause
 */

package org.example.app;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.kdb.app.Document;

public class DocumentTest 
{
    @Test
    void createDoc(TestReporter reporter)
    {
        Path tempDir;
        try {
            tempDir = Files.createTempDirectory("testdb_");

            String path = tempDir.resolve("testdoc.json").toString();
            reporter.publishEntry(path);
            Document myDoc = new Document(path);
            reporter.publishEntry(myDoc.read().toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}