package com.hks.producer.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    public ResultWrap applicationException(HttpServletRequest request,
                                           HttpServletResponse response,
                                           ApplicationException exception) {
        ResultWrap result = new ResultWrap();
        response.setStatus(exception.getStatusCode());
        result.setMessage(exception.getErrorMsg());
        result.setCode(exception.getErrorCode());
        return result;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultWrap throwableException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Exception exception) {
        ResultWrap result = new ResultWrap();
        response.setStatus(500);
        result.setMessage(getExceptionMsg(exception));
        result.setCode("ApplicationException_001");
        return result;
    }

    private String getExceptionMsg(Exception e) {
        return null != e.getMessage() ?
            e.getMessage() : e.toString();
    }
}
