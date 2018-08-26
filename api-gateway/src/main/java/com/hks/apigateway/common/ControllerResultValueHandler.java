package com.hks.apigateway.common;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

public class ControllerResultValueHandler implements HandlerMethodReturnValueHandler {

    private RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor;

    public ControllerResultValueHandler(RequestResponseBodyMethodProcessor processor) {
        this.requestResponseBodyMethodProcessor = processor;
    }

    /**
     * 只处理包含@RestController、@ResponseBody注解的控制器
     */
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        Class<?> controllerClass = returnType.getContainingClass();
        returnType.getMethodAnnotation(ResponseBody.class);

        return controllerClass.isAnnotationPresent(RestController.class)
            || controllerClass.isAnnotationPresent(ResponseBody.class)
            || returnType.getMethodAnnotation(ResponseBody.class) != null;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        if (!(returnValue instanceof ControllerResult)) {
            ControllerResult responseInfo = new ControllerResult();
            responseInfo.setResult(returnValue);
            returnValue = responseInfo;
        }

        requestResponseBodyMethodProcessor.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }
}
