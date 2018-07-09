package com.hks.apigateway.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    public ControllerResult applicationException(HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 ApplicationException exception) {
        ControllerResult result = new ControllerResult();
        response.setStatus(exception.getStatusCode());
        result.setErrorMsg(exception.getErrorMsg());
        result.setErrorCode(exception.getErrorCode());
        return result;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ControllerResult throwableException(HttpServletRequest request,
                                               HttpServletResponse response,
                                               Exception exception) {
        ControllerResult result = new ControllerResult();
        response.setStatus(500);
        result.setErrorMsg(getExceptionMsg(exception));
        result.setErrorCode("ApplicationException_001");
        return result;
    }

    private String getExceptionMsg(Exception e) {
        return null != e.getMessage() ?
            e.getMessage() : e.toString();
    }
}
