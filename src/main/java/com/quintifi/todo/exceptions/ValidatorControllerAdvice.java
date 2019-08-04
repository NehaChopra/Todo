package com.quintifi.todo.exceptions;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.quintifi.todo.domain.network.response.BaseResponse;


@RestControllerAdvice(basePackages = {"com.quintifi.todo"} )
@ControllerAdvice(basePackages = {"com.quintifi.todo"} )
public class ValidatorControllerAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @ResponseBody
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> authExceptionHandler(ApiException ex, WebRequest request) {
        BaseResponse response = new BaseResponse();
        Map<String, String> errors = ex.getErrors();
        if(!CollectionUtils.isEmpty(errors)) {
        	for (Map.Entry<String,String> entry : errors.entrySet())  {
        		response.setError(entry.getKey());
        		response.setErrorCode(entry.getValue());
        	}
        }
        logger.error(response.toString());
        return ResponseEntity.ok(response);
    }
} 