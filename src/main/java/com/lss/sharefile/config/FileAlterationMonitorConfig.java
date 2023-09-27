package com.lss.sharefile.config;

import com.lss.sharefile.listener.FileListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @Author: lss
 * @Date: 2023/09/25/22:20
 * @Description:
 */
@Configuration
public class FileAlterationMonitorConfig {

    @Value("${sharefile.path}")
    private String path;
    @Value("${sharefile.filetime}")
    private String filetime;


    @Bean
    public FileAlterationMonitor fileAlterationMonitor() throws Exception {
        long l = Long.parseLong(filetime);
        FileAlterationMonitor monitor = new FileAlterationMonitor(l);
        FileAlterationObserver observer = new FileAlterationObserver(new File(path));
        monitor.addObserver(observer);
        FileListener listener = new FileListener();
        observer.addListener(listener);
        monitor.start();
        return monitor;
    }
}
