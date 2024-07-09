package com.example.demo.controller;


import com.example.demo.constant.ResMsg;
import com.example.demo.response.Response;
import com.example.demo.service.OtherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.example.demo.constant.Constants.SYSTEM_ID;
import static com.example.demo.constant.Constants.X_SYSTEM_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OtherController.class)
public class OtherControllerTest {

    private final String EXCEPT_SUCCESS = "{\"code\":1,\"msg\":\"数据获取成功\",\"data\":\"SUCCESS\"}";
    private final String EXCEPT_INSUFFICIENT_PERMISSIONS = "{\"code\":-1,\"data\":\"INSUFFICIENT_PERMISSIONS\",\"msg\":\"权限不足\"}";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OtherService otherService;


    @Test
    public void testCreateUserTable() throws Exception {
        when(otherService.createUserTable()).thenReturn(Response.success(ResMsg.SUCCESS));
        ResultActions resultActions = mockMvc.perform(post("/other/createUserTable").header(X_SYSTEM_ID, SYSTEM_ID)).andExpect(status().isOk()).andExpect(content().string(EXCEPT_SUCCESS));
        Assertions.assertEquals(EXCEPT_SUCCESS, resultActions.andReturn().getResponse().getContentAsString());
    }

    /**
     * 因為如果是servlet返回的header缺少參數錯誤訊息的話，沒有辦法直接在mockito 裡面設定返回內容去測試
     * 只能用攔截器的方式先把錯誤訊息抓下來，改成自己要的錯誤訊息
     * @throws Exception
     */
    @Test
    public void testCreateUserTable_not_with_system_id() throws Exception {
        when(otherService.createUserTable()).thenReturn(Response.fail(ResMsg.INSUFFICIENT_PERMISSIONS));
        ResultActions resultActions =mockMvc.perform(post("/other/createUserTable")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{}")  // 如果有请求体，也需要设置内容
//                        .header("Content-Type", "application/json")
                ).andExpect(status().isBadRequest())  // 验证返回的HTTP状态码为400
                .andExpect(result -> assertThat(result.getResponse().getErrorMessage()).isEqualTo(EXCEPT_INSUFFICIENT_PERMISSIONS));
        Assertions.assertEquals(EXCEPT_INSUFFICIENT_PERMISSIONS, resultActions.andReturn().getResponse().getErrorMessage());
    }

    @Test
    public void testCreateClassTable() throws Exception {
        when(otherService.createClassTable()).thenReturn(Response.success(ResMsg.SUCCESS));
        ResultActions resultActions = mockMvc.perform(post("/other/createClassTable").header(X_SYSTEM_ID, SYSTEM_ID)).andExpect(status().isOk()).andExpect(content().string(EXCEPT_SUCCESS));
        Assertions.assertEquals(EXCEPT_SUCCESS, resultActions.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void testCreateClassTable_not_with_system_id() throws Exception {
        when(otherService.createClassTable()).thenReturn(Response.fail(ResMsg.INSUFFICIENT_PERMISSIONS));
        ResultActions resultActions =mockMvc.perform(post("/other/createClassTable")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{}")  // 如果有请求体，也需要设置内容
//                        .header("Content-Type", "application/json")
                ).andExpect(status().isBadRequest())  // 验证返回的HTTP状态码为400
                .andExpect(result -> assertThat(result.getResponse().getErrorMessage()).isEqualTo(EXCEPT_INSUFFICIENT_PERMISSIONS));
        Assertions.assertEquals(EXCEPT_INSUFFICIENT_PERMISSIONS, resultActions.andReturn().getResponse().getErrorMessage());
    }
    @Test
    public void testCreateClassOrderTable() throws Exception {
        when(otherService.createClassOrderTable()).thenReturn(Response.success(ResMsg.SUCCESS));
        ResultActions resultActions = mockMvc.perform(post("/other/createClassOrderTable").header(X_SYSTEM_ID, SYSTEM_ID)).andExpect(status().isOk()).andExpect(content().string(EXCEPT_SUCCESS));
        Assertions.assertEquals(EXCEPT_SUCCESS, resultActions.andReturn().getResponse().getContentAsString());
    }
    @Test
    public void testCreateNewsTable() throws Exception {
        when(otherService.createNewsTable()).thenReturn(Response.success(ResMsg.SUCCESS));
        ResultActions resultActions = mockMvc.perform(post("/other/createNewsTable").header(X_SYSTEM_ID, SYSTEM_ID)).andExpect(status().isOk()).andExpect(content().string(EXCEPT_SUCCESS));
        Assertions.assertEquals(EXCEPT_SUCCESS, resultActions.andReturn().getResponse().getContentAsString());
    }
}