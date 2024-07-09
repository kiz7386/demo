package com.example.demo.service;

import com.example.demo.dao.ClassDao;
import com.example.demo.dao.ClassOrderDao;
import com.example.demo.dao.NewsDao;
import com.example.demo.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(OtherService.class)
class OtherServiceTest {

    private final String SUCCESS_CREATE_TABLE = "success create the table";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDao userDao;
    @MockBean
    private ClassDao classDao;
    @MockBean
    private ClassOrderDao classOrderDao;
    @MockBean
    private NewsDao newsDao;

    @Test
    void createUserTable() {
        when(userDao.createUserTable()).thenReturn(SUCCESS_CREATE_TABLE);
        assertEquals(SUCCESS_CREATE_TABLE, userDao.createUserTable());
    }
    @Test
    void createUserTable_fail() {
        when(userDao.createUserTable()).thenReturn("新增失败");
        assertEquals("新增失败", userDao.createUserTable());
    }

    @Test
    void createClassTable() {
        when(classDao.createClassTable()).thenReturn(SUCCESS_CREATE_TABLE);
        assertEquals(SUCCESS_CREATE_TABLE, classDao.createClassTable());
    }

    @Test
    void createClassOrderTable() {
        when(classOrderDao.createClassOrderTable()).thenReturn(SUCCESS_CREATE_TABLE);
        assertEquals(SUCCESS_CREATE_TABLE, classOrderDao.createClassOrderTable());
    }

    @Test
    void createNewsTable() {
        when(newsDao.createNewsTable()).thenReturn(SUCCESS_CREATE_TABLE);
        assertEquals(SUCCESS_CREATE_TABLE, newsDao.createNewsTable());
    }
}