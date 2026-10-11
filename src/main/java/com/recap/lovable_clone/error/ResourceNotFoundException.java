package com.recap.lovable_clone.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String resourceId;
//    public ResourceNotFoundException(String message) {
//        super(message);
//    }
}
