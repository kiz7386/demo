package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.vo.UserVO;
import com.example.demo.response.Response;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public JSONObject testCon1(){
        JSONObject c = userService.testMethod();
        return c;
    }

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    // JSONObject 格式
    public Response saveUser(@RequestBody UserVO vo){
        return userService.saveUser(vo.getUserName());
    }

    @RequestMapping(value = "/getUserData",method = {RequestMethod.GET})
    public Response<UserVO> getUserData(@RequestParam("id") Integer id){
        return userService.getUserData(id);
    }
    @RequestMapping(value = "/getUserData1",method = {RequestMethod.GET})
    public Response<UserVO> getUserData1(@RequestParam("id") Integer id){
        return userService.getUserData1(id);
    }
    @RequestMapping(value = "/getUserDataList",method = {RequestMethod.GET})
    public Response<List<UserVO>> getUserDataList(@RequestParam(value = "idList", required = false) List<Integer> idList){
        return userService.getUserDataList(idList);
    }
    @RequestMapping(value = "/getUserDataList1",method = {RequestMethod.GET})
    public Response<List<UserVO>> getUserDataList1(HttpServletRequest req){
        String idList = req.getParameter("idList");
        List<Integer> collect = Arrays.stream(idList.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        return userService.getUserDataList1(collect);
    }
}
