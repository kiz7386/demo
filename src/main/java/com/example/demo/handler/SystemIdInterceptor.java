package com.example.demo.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.constant.ResMsg;
import com.example.demo.response.Response;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.demo.constant.Constants.X_SYSTEM_ID;

public class SystemIdInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String systemId = request.getHeader(X_SYSTEM_ID);
        if (systemId == null || systemId.isEmpty()) {
            // 处理缺少 x_system_id 头部的情况
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, JSONObject.toJSONString(Response.fail(ResMsg.INSUFFICIENT_PERMISSIONS, ResMsg.INSUFFICIENT_PERMISSIONS.name())));
            return false;  // 终止请求处理
        }
        return true;  // 继续处理请求
    }
}
