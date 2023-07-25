package com.example.demo.controller;

import com.example.demo.model.vo.ClassVO;
import com.example.demo.response.Response;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 將此類別設定為api接口類別, 並返回ＪＳＯＮ格式的 元件標籤（@Component), 有貼標籤的類別無法另外用 new
@RequestMapping(value = "/class")
public class ClassController {

    @Autowired  // 將類別或介面注入 的標籤
    private ClassService classService;

    // 掛在api 方法上（可設定路徑, 方法, 或者把路徑拿來當變數）, produces 設定Response header 為 contentType = application/json;chartset=utf-8
    @GetMapping(value = "/getUserClassData2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
                                            // 傳入參數設定名稱 （?key=value&key=value...）
    public Response<ClassVO> getUserClassData2(@RequestParam("id") Integer id){
        return classService.getUserClassData2(id);
    }
    @RequestMapping(value = "/getClassDataList",method = RequestMethod.GET)
    public Response<List<ClassVO>> getClassDataList(@RequestParam("classIdList")List<Integer> ids){
        return classService.getClassDataList(ids);
    }
    @RequestMapping(value = "/saveClass",method = RequestMethod.POST)
                              // JSONObject 格式{"id":1,"className":"日文課"}
    public Response saveClass(@RequestBody ClassVO vo){
        return classService.saveClass(vo.getClassName());
    }

    /**
     * 更新課程名稱
     * @param cl
     * @return
     */
    @RequestMapping(value = "/updateClassName",method = RequestMethod.POST)
    public Response updateClassName(@RequestBody ClassVO cl){
        return classService.updateClassName(cl);
    }
    @RequestMapping(value = "/deleteClass",method = RequestMethod.POST)
    public Response deleteClass(@RequestBody ClassVO cl){
        return classService.deleteClass(cl);
    }
}
