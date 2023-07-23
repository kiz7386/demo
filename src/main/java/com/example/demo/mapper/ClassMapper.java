package com.example.demo.mapper;

import com.example.demo.model.vo.ClassVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

// 此標籤 判斷為 資料庫語句 的元件 , 如果在DemoApplication類別上寫＠MapperScan("com.example.demo.dao") , 也可以不寫@Mapper
// 但是建議還是都寫 @Mapper 不然要是dao的裡面有其他沒有要當Mapper的介面 , 就會報錯
@Mapper
public interface ClassMapper {
    // 為MyBatis的查詢標籤, 還有@Insert, @Update, @Delete 為新增修改刪除用）, 一般帶入的參數 用 #{參數} 格式
    @Select("SELECT * FROM class WHERE id in " +
            " (SELECT class_id FROM class_order WHERE user_id = #{id})")
    // @param 是 帶入參數名稱
    public ClassVO getUserClassData(@Param("id") Integer id);

}
