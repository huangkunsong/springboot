package com.hks.producer.common;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

@ControllerAdvice
public class ControllerResultHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        Class clazz = returnType.getDeclaringClass();
        Method method = returnType.getMethod();
        if (clazz.isAnnotationPresent(NotResultWrap.class) ||
            method.isAnnotationPresent(NotResultWrap.class) ||
            returnType.getGenericParameterType().getTypeName().equals("void")) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        ResultWrap resultWrap = new ResultWrap();
        resultWrap.setData(body);
        return resultWrap;
    }
}
