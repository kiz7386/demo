package com.example.demo.service;

import com.example.demo.constant.ResMsg;
import com.example.demo.dao.ClassDao;
import com.example.demo.dao.ClassOrderDao;
import com.example.demo.dao.NewsDao;
import com.example.demo.dao.UserDao;
import com.example.demo.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OtherService {

    private static final Logger logger = LoggerFactory.getLogger(OtherService.class);
    private final UserDao userDao;
    private final ClassDao classDao;
    private final ClassOrderDao classOrderDao;
    private final NewsDao newsDao;

    public OtherService(UserDao userDao, ClassDao classDao, ClassOrderDao classOrderDao, NewsDao newsDao) {
        this.userDao = userDao;
        this.classDao = classDao;
        this.classOrderDao = classOrderDao;
        this.newsDao = newsDao;
    }

    public Response createUserTable() {
        try {
            return Response.success(ResMsg.ADD_SUCCESS, userDao.createUserTable());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Response.fail(ResMsg.ADD_FAIL);
        }
    }

    public Response createClassTable() {
        try {
            return Response.success(ResMsg.ADD_SUCCESS, classDao.createClassTable());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Response.fail(ResMsg.ADD_FAIL);
        }
    }

    public Response createClassOrderTable() {
        try {
            return Response.success(ResMsg.ADD_SUCCESS, classOrderDao.createClassOrderTable());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Response.fail(ResMsg.ADD_FAIL);
        }
    }

    public Response createNewsTable() {
        try {
            return Response.success(ResMsg.ADD_SUCCESS, newsDao.createNewsTable());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Response.fail(ResMsg.ADD_FAIL);
        }
    }


}
