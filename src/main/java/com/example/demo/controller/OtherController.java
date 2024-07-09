package com.example.demo.controller;

import com.example.demo.constant.ResMsg;
import com.example.demo.response.Response;
import com.example.demo.service.OtherService;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.constant.Constants.SYSTEM_ID;
import static com.example.demo.constant.Constants.X_SYSTEM_ID;

@RestController
@RequestMapping("/other")
public class OtherController {

    private final OtherService otherService;

    public OtherController(OtherService otherService) {
        this.otherService = otherService;
    }

    @RequestMapping(value = "/createUserTable",method = {RequestMethod.POST})
    public Response createUserTable(@RequestHeader(X_SYSTEM_ID) String userId){
        if (!SYSTEM_ID.equalsIgnoreCase(userId)){
            return Response.fail(ResMsg.INSUFFICIENT_PERMISSIONS);
        }
        return otherService.createUserTable();
    }
    @RequestMapping(value = "/createClassTable",method = {RequestMethod.POST})
    public Response createClassTable(@RequestHeader(X_SYSTEM_ID) String userId){
        if (!SYSTEM_ID.equalsIgnoreCase(userId)){
            return Response.fail(ResMsg.INSUFFICIENT_PERMISSIONS);
        }
        return otherService.createClassTable();
    }
    @RequestMapping(value = "/createClassOrderTable",method = {RequestMethod.POST})
    public Response createClassOrderTable(@RequestHeader(X_SYSTEM_ID) String userId){
        if (!SYSTEM_ID.equalsIgnoreCase(userId)){
            return Response.fail(ResMsg.INSUFFICIENT_PERMISSIONS);
        }
        return otherService.createClassOrderTable();
    }
    @RequestMapping(value = "/createNewsTable",method = {RequestMethod.POST})
    public Response createNewsTable(@RequestHeader(X_SYSTEM_ID) String userId){
        if (!SYSTEM_ID.equalsIgnoreCase(userId)){
            return Response.fail(ResMsg.INSUFFICIENT_PERMISSIONS);
        }
        return otherService.createNewsTable();
    }
}
