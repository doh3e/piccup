package com.ssafy.piccup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 커스텀 예외 처리한 반환값 지정
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonalInfoNotFoundException.class) // 커스텀 예외
    public ResponseEntity<String> handleNotFoundException(PersonalInfoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}