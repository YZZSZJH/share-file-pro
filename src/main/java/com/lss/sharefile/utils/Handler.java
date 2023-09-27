package com.lss.sharefile.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * @Author: lss
 * @Date: 2023/09/21/21:31
 * @Description:
 */


public class Handler {
    private final byte[] buffer = new byte[1024];
    private MessageDigest md5 = null;
    private File file = null;

    public Handler(File file) {
        if (!file.isFile()) {
            System.out.println("File not found!");
        }
        try {
            this.md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("MD5 Method Error!");
        }
        this.file = file;
    }

    public String getMD5() {
        int length = 0;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            while ((length = inputStream.read(buffer)) != -1) {
                md5.update(buffer, 0, length);
            }
            return new BigInteger(1, md5.digest()).toString(16);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
