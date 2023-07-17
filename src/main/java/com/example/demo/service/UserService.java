package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.MainDataBaseMapper;
import com.example.demo.model.vo.Pen;
import com.example.demo.model.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    MainDataBaseMapper mapper;

    public JSONObject testMethod(){
//        JSObject jsObject = testMapper.retrunJSON();
        JSONObject jsObject = new JSONObject();
        Pen pen = new Pen();
        pen.setBrand("skb");
        pen.setPrice(BigDecimal.TEN);
        jsObject.put("aaa",pen);
        return jsObject;
    }
    public User getUserData(Integer id){
        return mapper.getUserData(id);
    }

    public List<User> getUserDataList(List<Integer> ids){
        List<User> userList = new ArrayList<>();
        if(!ObjectUtils.isEmpty(ids)){
            userList = mapper.getUserList(ids);
        }
        return userList;
    }
}
