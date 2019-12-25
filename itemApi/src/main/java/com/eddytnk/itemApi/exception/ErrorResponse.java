package com.eddytnk.itemApi.exception;

import lombok.Data;

/**
 * Author: Edward Tanko <br/>
 * Date: 12/24/19 9:23 PM <br/>
 */
@Data
public class ErrorResponse {

    private String code;
    private String message;
    private String path;

}
