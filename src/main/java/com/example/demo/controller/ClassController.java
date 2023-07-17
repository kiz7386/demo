package com.example.demo.controller;

import com.example.demo.model.vo.Class;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClassController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/getUserClassData",method = RequestMethod.POST)
    public Class getUserClassData(@RequestBody Class classObj){
        return classService.getUserClassData(classObj.getId());
    }
}
