/*
 * Copyright (c) 2025 LJC
 * 
 * SPDX-License-Identifier: BSD-2-Clause
 */

package org.kdb.app;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.*;

public class Document 
{
    private File        docFile;
    private JsonElement buffer;
    public  boolean     buffering;
    
    /* 
     * TODO: Implement CRUD operations for documents
     * Create, Read, Update, Delete
     * 
     * For now implement non-buffering operations. Enable buffering later
     */

    /**
     * @param docPath path to the document file
     */
    public Document(String path)
    {
        docFile = new File(path);
        if (docFile.exists())
        {
            System.out.println("Opening file: " + path);
        } else 
        {
            System.out.println("File does not exist: " + path);
            
            System.out.println("Creating file at: " + path);
            try { docFile.createNewFile(); }
            catch(IOException e) 
            { 
                System.out.println("Error creating file: " + path); 
                e.printStackTrace();
            }
            System.out.println("Created file: " + path);
        }
    }

    public JsonElement read()
    {
        if (buffering) { return buffer; }
        else { return readUnbuffered(); }

    }

    private JsonElement readUnbuffered()
    {
        try (FileReader reader = new FileReader(docFile))
        {
            JsonElement root = JsonParser.parseReader(reader);

            if (root.isJsonObject()) { return root.getAsJsonObject(); }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return new JsonObject();
    }
}