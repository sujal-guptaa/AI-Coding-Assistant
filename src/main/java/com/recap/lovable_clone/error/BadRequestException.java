package com.recap.lovable_clone.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class BadRequestException extends RuntimeException {
    String message;
//    public BadRequestException(String message) {
//        super(message);
//    }
}
