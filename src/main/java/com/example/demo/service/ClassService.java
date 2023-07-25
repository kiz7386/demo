package com.example.demo.service;

import com.example.demo.mapper.MainDataBaseMapper;
import com.example.demo.model.vo.ClassVO;
import com.example.demo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // 將此類別設定為業務邏輯類別 的元件標籤（@Component), 有貼標籤的類別無法另外用 new
public class ClassService {

    @Autowired
    private MainDataBaseMapper mapper;

    public Response<ClassVO> getUserClassData(Integer id){
        return Response.success(mapper.getUserClassData(id));
    }


}
