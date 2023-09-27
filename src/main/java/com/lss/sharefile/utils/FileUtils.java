package com.lss.sharefile.utils;

import java.io.*;

/**
 * @Author: lss
 * @Date: 2023/09/21/22:06
 * @Description:
 */
public class FileUtils {
    /**
     * 文件转换为字节流
     * @param filePath
     * @return
     * @throws Exception
     */
    public static byte[] fileToByte(String filePath) throws Exception {
        byte[] data = new byte[0];
        File file = new File(filePath);
        if (file.exists()) {
            FileInputStream in = new FileInputStream(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
            byte[] cache = new byte[1024];
            int nRead = 0;
            while ((nRead = in.read(cache)) != -1) {
                out.write(cache, 0, nRead);
                out.flush();
            }
            out.close();
            in.close();
            data = out.toByteArray();
        }
        return data;
    }

    /**
     * 字节转文件
     * @param bytes
     * @param filePath
     * @throws Exception
     */
    public static void byteArrayToFile ( byte[] bytes, String filePath) throws Exception {
        InputStream in = new ByteArrayInputStream(bytes);
        File destFile = new File(filePath);
        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }
        destFile.createNewFile();
        OutputStream out = new FileOutputStream(destFile);
        byte[] cache = new byte[1024];
        int nRead = 0;
        while ((nRead = in.read(cache)) != -1) {
            out.write(cache, 0, nRead);
            out.flush();
        }
        out.close();
        in.close();
    }
}
