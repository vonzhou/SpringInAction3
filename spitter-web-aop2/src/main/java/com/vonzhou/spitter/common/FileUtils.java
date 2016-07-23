package com.vonzhou.spitter.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by vonzhou on 16/4/20.
 */
public class FileUtils {
    public static void writeByteArrayToFile(File file, byte[] bytes) throws IOException{
        file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();
    }
}
