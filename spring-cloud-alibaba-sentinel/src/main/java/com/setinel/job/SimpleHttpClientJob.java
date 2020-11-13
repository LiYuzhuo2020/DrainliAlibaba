package com.setinel.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.*;

/**
 *
 * 简单的定时访问http任务
 *
 * @Author: Drainli
 **/
@Component
public class SimpleHttpClientJob {

    @Scheduled(cron = "0/5 * * * * ?")
    public void accessHttp() throws MalformedURLException , IOException{
     //   System.out.println("开始执行定时任务");

       URL url = new URL("http://localhost:8084/one") ;
       // 创建连接服务
       HttpURLConnection connection = (HttpURLConnection) url.openConnection() ;
       // 连接
        connection.connect();
        // 输入流获得执行的结果
        BufferedInputStream ins = new BufferedInputStream(connection.getInputStream()) ;
        // 读取输入流直到结束为止
        int line = 0 ;
        // 字节数组
        byte[] bytes = new byte[1024] ;

        while ((line = ins.read(bytes)) != -1){
            ins.read(bytes) ;
        }

    }

}
