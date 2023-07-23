package com.example.demo.controller;

import com.example.demo.model.vo.ClassOrderVO;
import com.example.demo.response.Response;
import com.example.demo.service.ClassOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/classOrder") // 將此類別設定為api接口類別, 並返回ＪＳＯＮ格式的 元件標籤（@Component), 有貼標籤的類別無法另外用 new
public class ClassOrderController {

    @Autowired  // 將類別或介面注入 的標籤
    private ClassOrderService classOrderService;

    @RequestMapping(value = "/saveClassOrder",method = RequestMethod.POST)
                              // JSONObject 格式
    public Response saveClassOrder(@RequestBody ClassOrderVO classOrderVO){
        return classOrderService.saveClassOrder(classOrderVO);
    }

}
