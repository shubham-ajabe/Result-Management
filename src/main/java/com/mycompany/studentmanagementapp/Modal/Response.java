package com.mycompany.studentmanagementapp.modal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private String status;
    private int statusCode;
    private String message;
    private T payload;
    private Object errors;

    public static <T> Response<T> ok(String ds, HttpStatus created){
        Response<T> response = new Response<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatus(HttpStatus.OK.name());
        return response;
    }

    public static <T> Response<T> badRequest(){
        Response<T> response = new Response<>();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setStatus(HttpStatus.BAD_REQUEST.name());
        return response;
    }

    public static <T> Response<T> unAuthorized(){
        Response<T> response = new Response<>();
        response.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        response.setStatus(HttpStatus.UNAUTHORIZED.name());
        return response;
    }

    public static <T> Response<T> notFound(){
        Response<T> response = new Response<>();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setStatus(HttpStatus.NOT_FOUND.name());
        return response;
    }

    public static <T> Response<T> preConditionFailed(){
        Response<T> response = new Response<>();
        response.setStatusCode(HttpStatus.PRECONDITION_REQUIRED.value());
        response.setStatus(HttpStatus.PRECONDITION_REQUIRED.name());
        return response;
    }

    public static <T> Response<T> duplicateFound(){
        Response<T> response = new Response<>();
        response.setStatusCode(HttpStatus.CONFLICT.value());
        response.setStatus(HttpStatus.CONFLICT.name());
        return response;
    }

    public static <T> Response<T> internalError(){
        Response<T> response = new Response<>();
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
        return response;
    }
}

