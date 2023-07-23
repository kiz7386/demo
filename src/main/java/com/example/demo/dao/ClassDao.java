package com.example.demo.dao;

import com.example.demo.model.vo.ClassVO;

import java.util.List;

public interface ClassDao {

    public String createClassTable();
    public ClassVO queryClass(Integer id);
    public List<ClassVO> getClassDataList(List<Integer> ids);
    public String saveClass(String className);
    public String updateClassName(String className, Integer id);
    public String deleteClass(Integer id);
}
