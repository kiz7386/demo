package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.constant.ResMsg;
import com.example.demo.mapper.MainDataBaseMapper;
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
    private MainDataBaseMapper mapper;

    public JSONObject testMethod(){
        JSONObject jsObject = new JSONObject();
        PenVO penVO = new PenVO();
        penVO.setBrand("skb");
        penVO.setPrice(BigDecimal.TEN);
        jsObject = JSONObject.parseObject(JSONObject.toJSONString(penVO));
        return jsObject;
    }


    public Response<UserVO> getUserData(Integer id){
        return Response.success(ResMsg.GET_DATA_SUCCESS, mapper.getUserData(id));
    }

    public Response<List<UserVO>> getUserDataList(List<Integer> ids){
        List<UserVO> userVOList = new ArrayList<>();
        if(!ObjectUtils.isEmpty(ids)){
            userVOList = mapper.getUserList(ids);
        }
        return Response.success(ResMsg.GET_DATA_SUCCESS, userVOList);
    }
}
