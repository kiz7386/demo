package com.example.demo.service;

import com.example.demo.constant.ResMsg;
import com.example.demo.dao.ClassDao;
import com.example.demo.model.vo.ClassVO;
import com.example.demo.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // 將此類別設定為業務邏輯類別 的元件標籤（@Component), 有貼標籤的類別無法另外用 new
public class ClassService {

    @Autowired // (required = false)如果該 類別或者介面找不到，就不做注入動作
    private ClassDao classDao;


    public Response<ClassVO> getUserClassData2(Integer id){
        return Response.success(classDao.queryClass(id));
    }
    public Response<List<ClassVO>> getClassDataList(List<Integer> ids){
        return Response.success(classDao.getClassDataList(ids));
    }
    public Response saveClass(String className){
        return Response.success(ResMsg.ADD_SUCCESS, classDao.saveClass(className));
    }
    public Response updateClassName(ClassVO cl){
        return Response.success(ResMsg.ADD_SUCCESS, classDao.updateClassName(cl.getClassName(), cl.getId()));
    }
    public Response deleteClass(ClassVO cl){
        return Response.success(ResMsg.ADD_SUCCESS, classDao.deleteClass(cl.getId()));
    }

}
