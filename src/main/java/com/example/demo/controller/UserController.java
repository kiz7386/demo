package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.vo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public JSONObject testCon1(){
        JSONObject c = userService.testMethod();
        return c;
    }
    @RequestMapping(value = "/getUserData",method = {RequestMethod.GET, RequestMethod.POST})
    public User getUserData(@RequestParam("id") Integer id){
        return userService.getUserData(id);
    }
    @RequestMapping(value = "/getUserDataList",method = {RequestMethod.GET, RequestMethod.POST})
    public List<User> getUserDataList(@RequestParam(value = "idList", required = false) List<Integer> idList){
        return userService.getUserDataList(idList);
    }
}
