package com.example.subscriptionsAPI.config;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class SubscriptionsAPIErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        final Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        final Throwable error = super.getError(webRequest);
        if (error instanceof Exception ex) {
            errorAttributes.put("message", ex.getMessage());
        }
        return errorAttributes;
    }


}
