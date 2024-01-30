package com.fatma.university.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class CustomErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes=super.getErrorAttributes(webRequest,options);
        errorAttributes.put("success",Boolean.FALSE);
        errorAttributes.put("status",errorAttributes.get("error"));
        errorAttributes.put("exception",errorAttributes.get("message"));
        errorAttributes.remove("path");
        errorAttributes.remove("error");


        return errorAttributes;
    }
}
