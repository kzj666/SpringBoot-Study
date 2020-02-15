package com.kk.service;

/*
@author kzj
@date 2020/2/1 - 23:52
*/


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    //告诉spring这是一个异步方法,这样运行的时候spring就会开启一个线程池
    @Async
    public void hello(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理");
    }
}
