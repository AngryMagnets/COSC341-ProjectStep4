package com.example.projectstep4;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static String[] read(String filename, Context context, int lineNum){
        String[] out = null;
        try {
            FileInputStream fis = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == lineNum) {
                    out = line.split(",");
                }
                i++;
            }
            fis.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return out;
    }
}
