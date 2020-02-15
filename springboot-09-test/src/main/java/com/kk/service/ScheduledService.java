package com.kk.service;

/*
@author kzj
@date 2020/2/2 - 15:30
*/

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //cron 表达式-----秒 分 时 日 月 周几
    //可百度cron表达式
    /*
        "55 50 15 * * ?" ---->每天15点50分55秒执行一次
        "30 0/5 10,18 * * ?" ---->每天10点和18点，每隔五分钟执行一次
        "0 15 10 ? * 1-6" ---->每个月的周一到周六，10点15分执行
    */
    @Scheduled(cron="0/2 * * * * ?")
    public void hello(){
        System.out.println("hello!!!!!!!!!!!!");
    }
}
