package com.lss.sharefile;

import com.lss.sharefile.listener.FileListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class SharefileApplication {

    public static void main(String[] args) {
//        FileAlterationMonitor monitor = new FileAlterationMonitor(1000);
//        FileAlterationObserver observer = new FileAlterationObserver(new File("D:\\javademo\\sharefile\\src\\main\\java\\com\\lss\\sharefile\\text\\java.java"));
//        monitor.addObserver(observer);
//        FileListener listener = new FileListener();
//        observer.addListener(listener);
//        monitor.start();
        SpringApplication.run(SharefileApplication.class, args);
    }

}
