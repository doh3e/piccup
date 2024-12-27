package com.ssafy.piccup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 커스텀 예외
@ResponseStatus(HttpStatus.NOT_FOUND) // 404 상태 코드 설정
public class PersonalInfoNotFoundException extends RuntimeException {

    // 생성자 / 예외 메시지를 받아 부모 클래스(RuntimeException)에 전달
    public PersonalInfoNotFoundException(String message) {
        super(message);
    }
}
