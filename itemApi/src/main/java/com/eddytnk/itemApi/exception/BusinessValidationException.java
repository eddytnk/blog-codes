package com.eddytnk.itemApi.exception;

import lombok.Data;

/**
 * User: Edward Tanko <br/>
 * Date: 5/29/19 2:56 AM <br/>
 */
@Data
public class BusinessValidationException extends RuntimeException {
    public BusinessValidationException(String message) {
        super(message);
    }
}
