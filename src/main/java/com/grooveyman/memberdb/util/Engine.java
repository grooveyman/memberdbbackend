package com.grooveyman.memberdb.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class Engine {
    
    public static String saveBase64Image(String base64Image, String uploadDir) throws IOException{
        String[] parts = base64Image.split(",");
        String imageString = parts.length > 1 ? parts[1] : parts[0];

        byte[] data = Base64.getDecoder().decode(imageString);

        File dir = new File(uploadDir);
        if(!dir.exists()) dir.mkdirs();

        String filename = System.currentTimeMillis() + ".png";
        String filePath = uploadDir + "/" + filename;

        try(FileOutputStream fos = new FileOutputStream(filePath)){
            fos.write(data);
        }
        return filePath;
    }
}
