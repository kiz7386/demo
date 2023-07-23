package com.example.demo.service;

import com.example.demo.constant.ResMsg;
import com.example.demo.dao.ClassDao;
import com.example.demo.dao.ClassOrderDao;
import com.example.demo.dao.NewsDao;
import com.example.demo.dao.UserDao;
import com.example.demo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ClassDao classDao;
    @Autowired
    private ClassOrderDao classOrderDao;
    @Autowired
    private NewsDao newsDao;

    public Response createUserTable(){
        return Response.success(ResMsg.ADD_SUCCESS, userDao.createUserTable());
    }

    public Response createClassTable(){
        return Response.success(ResMsg.ADD_SUCCESS, classDao.createClassTable());
    }

    public Response createClassOrderTable(){
        return Response.success(ResMsg.ADD_SUCCESS, classOrderDao.createClassOrderTable());
    }

    public Response createNewsTable(){
        return Response.success(ResMsg.ADD_SUCCESS, newsDao.createNewsTable());
    }


}
