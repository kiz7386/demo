package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.vo.UserVO;
import com.example.demo.response.Response;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public JSONObject testCon1(){
        JSONObject c = userService.testMethod();
        return c;
    }


    @GetMapping(value = "/getUserData", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<UserVO> getUserData(@RequestParam("id") Integer id){
        return userService.getUserData(id);
    }

    @RequestMapping(value = "/getUserDataList",method = {RequestMethod.GET})
    public Response<List<UserVO>> getUserDataList(@RequestParam(value = "idList", required = false) List<Integer> idList){
        return userService.getUserDataList(idList);
    }
}
