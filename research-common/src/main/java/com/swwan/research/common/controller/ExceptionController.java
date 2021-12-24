//package com.swwan.research.common.controller;
//
//import com.swwan.research.common.exception.RequestServletException;
//import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Map;
//
///**
// * @author swwan
// * @date 2021/12/24 - 23:09
// */
//@Controller
//@RequestMapping("${server.error.path:${error.path:/error}}")
//public class ExceptionController extends AbstractErrorController {
//
//    public ExceptionController(ErrorAttributes errorAttributes) {
//        super(errorAttributes);
//    }
//
//    @Override
//    @Deprecated
//    public String getErrorPath() {
//        return null;
//    }
//
//    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
//        throw new RuntimeException(getErrorMessage(request));
//    }
//
//    @RequestMapping
//
//    public Map<String, Object> error(HttpServletRequest request) {
//        throw new RequestServletException((HttpStatus.resolve((Integer) request.getAttribute("javax.servlet.error.status_code"))), getErrorMessage(request));
//    }
//
//    private String getErrorMessage(HttpServletRequest request) {
//        Object code = request.getAttribute("javax.servlet.error.status_code");
//        Object exceptionType = request.getAttribute("javax.servlet.error.exception_type");
//        Object message = request.getAttribute("javax.servlet.error.message");
//        Object path = request.getAttribute("javax.servlet.error.request_uri");
//        Object exception = request.getAttribute("javax.servlet.error.exception");
//
//        return String.format("code: %s,exceptionType: %s,message: %s,path: %s,exception: %s",
//                code, exceptionType, message, path, exception);
//    }
//}
