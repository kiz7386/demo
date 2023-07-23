package com.example.demo.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@EnableScheduling // 定時任務啟動元件
@Slf4j // log4j 服務執行日誌記錄 lombok元件
public class TestScheduled {

    Integer count = 0;

    @PostConstruct // 服務啟動時就執行一次的元件
    @Scheduled(cron = "0 * * * * ?")  // 設定多久執行一次的元件
    public void deleteAllKeys(){
        log.info(String.format("服務啟動的第_%s_分鐘", count++));
    }
}
