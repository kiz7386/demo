package com.example.demo.service;

import com.example.demo.mapper.MainDataBaseMapper;
import com.example.demo.model.vo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @Autowired
    MainDataBaseMapper mapper;

    public Class getUserClassData(Integer id){
        return mapper.getUserClassData(id);
    }

}
