package com.example.demo.service;

import com.example.demo.constant.ResMsg;
import com.example.demo.dao.ClassOrderDao;
import com.example.demo.model.vo.ClassOrderVO;
import com.example.demo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // 將此類別設定為業務邏輯類別 的元件標籤（@Component), 有貼標籤的類別無法另外用 new
public class ClassOrderService {

    @Autowired // (required = false)如果該 類別或者介面找不到，就不做注入動作
    private ClassOrderDao classOrderDao;

    public Response saveClassOrder(ClassOrderVO vo){
        return Response.success(ResMsg.ADD_SUCCESS, classOrderDao.saveClassOrder(vo.getUserId(), vo.getClassId()));
    }


}
