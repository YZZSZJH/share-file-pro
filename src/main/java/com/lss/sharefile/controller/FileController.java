package com.lss.sharefile.controller;

import com.alibaba.fastjson.JSON;
import com.lss.sharefile.entity.ShareFile;
import com.lss.sharefile.utils.FileUtils;
import com.lss.sharefile.utils.Handler;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: lss
 * @Date: 2023/09/21/21:00
 * @Description:
 */
@RestController
public class FileController {
    // 本机上传服务器 11111
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 上传
        ShareFile shareFile = new ShareFile();
        byte[] fileToByte = FileUtils.fileToByte("D:\\javademo\\sharefile\\src\\main\\java\\com\\lss\\sharefile\\text\\java.java");
        shareFile.setFile(fileToByte);
        shareFile.setUser("B");
        shareFile.setState(0);
        File file = new File("D:\\javademo\\sharefile\\src\\main\\java\\com\\lss\\sharefile\\text\\java.java");
        Handler handler = new Handler(file);
        String md5 = handler.getMD5();
        shareFile.setFilemd5(md5);
        String s = JSON.toJSONString(shareFile);
//        response.setHeader("content-type", "text/html;charset=UTF-8");
        //获取OutputStream输出流
//        OutputStream os=response.getOutputStream();
//        os.write(fileToByte);
        return s;

    }


    // 从服务器同步本机
    @RequestMapping("/download")
    public String download(){
        //

        //


        return "文件获取成功";
    }

}
