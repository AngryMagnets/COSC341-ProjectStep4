package com.example.projectstep4;

import android.content.Context;

import java.io.FileOutputStream;

public class FileWriter {
public static void write(String filename, String contents, Context context){
    FileOutputStream outputStream;
    try {
        outputStream = context.openFileOutput(filename, Context.MODE_APPEND);
        outputStream.write(contents.getBytes());
        outputStream.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
