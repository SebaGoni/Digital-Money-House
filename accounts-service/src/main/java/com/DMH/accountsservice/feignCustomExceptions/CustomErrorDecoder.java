package com.DMH.accountsservice.feignCustomExceptions;

import com.DMH.accountsservice.exceptions.BadRequestException;
import com.DMH.accountsservice.exceptions.ConflictException;
import com.DMH.accountsservice.exceptions.ResourceNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder  implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400: return new BadRequestException("Bad request, check information");
            case 404: return new ResourceNotFoundException("Resource not found");
            case 409: return new ConflictException("Resource already exists");
            default: return new Exception("Try again later");
        }

    }
}
