package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.constant.ResMsg;
import com.example.demo.dao.UserDao;
import com.example.demo.model.vo.PenVO;
import com.example.demo.model.vo.UserVO;
import com.example.demo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public JSONObject testMethod(){
        JSONObject jsObject = new JSONObject();
        PenVO penVO = new PenVO();
        penVO.setBrand("skb");
        penVO.setPrice(BigDecimal.TEN);
        jsObject = JSONObject.parseObject(JSONObject.toJSONString(penVO));
        return jsObject;
    }

    public Response saveUser(String userName){
        return Response.success(ResMsg.ADD_SUCCESS, userDao.saveUser(userName));
    }

    public Response<UserVO> getUserData1(Integer id){
        return Response.success(ResMsg.GET_DATA_SUCCESS, userDao.queryUser(id));
    }

    public Response<List<UserVO>> getUserDataList1(List<Integer> ids){
        List<UserVO> userVOList = new ArrayList<>();
        if(!ObjectUtils.isEmpty(ids)){
            userVOList = userDao.getUserDataList(ids);
        }
        return Response.success(ResMsg.GET_DATA_SUCCESS, userVOList);
    }
}
