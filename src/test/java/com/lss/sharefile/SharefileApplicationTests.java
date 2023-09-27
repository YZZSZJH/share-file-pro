package com.lss.sharefile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lss.sharefile.entity.ShareFile;
import com.lss.sharefile.listener.FileListener;
import com.lss.sharefile.utils.FileMonitor;
import com.lss.sharefile.utils.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SharefileApplicationTests {

    @Test
    void contextLoads() throws Exception {
        String s = "{\n" +
                "  \"file\": \"Ly8gbHNz\",\n" +
                "  \"filemd5\": \"158e89bb7a19bfd2284c4cdd171bc56d\",\n" +
                "  \"state\": 0,\n" +
                "  \"user\": \"B\"\n" +
                "}";

        ShareFile shareFile = JSON.parseObject(s, new TypeReference<ShareFile>(){});
        System.out.println(shareFile.getFilemd5());
        FileUtils.byteArrayToFile(shareFile.getFile(),"D:\\javademo\\sharefile\\src\\main\\java\\com\\lss\\sharefile\\text\\java.txt");
    }

    public static void main(String[] args) throws Exception {
        // 监控间隔
        FileMonitor fileMonitor = new FileMonitor(100000);
        fileMonitor.monitor("D:\\javademo\\sharefile\\src\\main\\java\\com\\lss\\sharefile\\text", new FileListener());
        fileMonitor.start();
    }

}
