package com.example.demo.createtable;

import com.example.demo.controller.OtherController;
import com.example.demo.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static com.example.demo.constant.Constants.SYSTEM_ID;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 建表整合測試
 */
@SpringBootTest
@Transactional
@Rollback
public class CreateTableTest {

    @Autowired
    OtherController otherController;
    @Test
    void create_userTable() {
        Response actual = otherController.createUserTable(SYSTEM_ID);
        assertNotNull(actual);
    }
}
