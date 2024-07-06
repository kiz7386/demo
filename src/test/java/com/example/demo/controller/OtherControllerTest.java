package com.example.demo.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.example.demo.constant.ResMsg;
import com.example.demo.response.Response;
import com.example.demo.service.OtherService;

import static com.example.demo.constant.Constants.SYSTEM_ID;
import static com.example.demo.constant.Constants.X_SYSTEM_ID;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OtherController.class)
public class OtherControllerTest {

    private final String exceptSuccess = "{\"code\":1,\"msg\":\"数据获取成功\",\"data\":\"SUCCESS\"}";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OtherService otherService;


    @Test
    public void testCreateUserTable() throws Exception {
        when(otherService.createUserTable()).thenReturn(Response.success(ResMsg.SUCCESS));
        ResultActions resultActions = mockMvc.perform(post("/createUserTable")).andExpect(status().isOk()).andExpect(content().string(exceptSuccess));
        Assertions.assertEquals(exceptSuccess, resultActions.andReturn().getResponse().getContentAsString());
    }
    @Test
    public void testCreateClassTable() throws Exception {
        when(otherService.createClassTable()).thenReturn(Response.success(ResMsg.SUCCESS));
        ResultActions resultActions = mockMvc.perform(post("/createClassTable").header(X_SYSTEM_ID, SYSTEM_ID)).andExpect(status().isOk()).andExpect(content().string(exceptSuccess));
        Assertions.assertEquals(exceptSuccess, resultActions.andReturn().getResponse().getContentAsString());
    }
}