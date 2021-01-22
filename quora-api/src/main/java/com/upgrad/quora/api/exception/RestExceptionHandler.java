package com.upgrad.quora.api.exception;

import com.upgrad.quora.api.model.ErrorResponse;
import com.upgrad.quora.service.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(InvalidQuestionException.class)
    public ResponseEntity<ErrorResponse> invalidQuestionException(InvalidQuestionException exception, WebRequest request) {
        String code=exception.getCode();
        String errorMessage=exception.getErrorMessage();
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(code).message(errorMessage), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AnswerNotFoundException.class)
    public ResponseEntity<ErrorResponse> answerNotFoundException(AnswerNotFoundException exception, WebRequest request) {
        String code=exception.getCode();
        String errorMessage=exception.getErrorMessage();
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(code).message(errorMessage), HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundException(UserNotFoundException exception, WebRequest request) {
        String code=exception.getCode();
        String errorMessage=exception.getErrorMessage();
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(code).message(errorMessage), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AuthorizationFailedException.class)
    public ResponseEntity<ErrorResponse> authorizationFailedException(AuthorizationFailedException exception, WebRequest request) {
        String code=exception.getCode();
        String errorMessage=exception.getErrorMessage();
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(code).message(errorMessage), HttpStatus.FORBIDDEN
        );
    }

    @ExceptionHandler(SignUpRestrictedException.class)
    public ResponseEntity<ErrorResponse> signUpRestrictionException(SignUpRestrictedException exception, WebRequest request) {
        String code=exception.getCode();
        String errorMessage=exception.getErrorMessage();
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(code).message(errorMessage), HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ErrorResponse> authenticationFailedException(AuthenticationFailedException exe, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exe.getCode()).message(exe.getErrorMessage()), HttpStatus.UNAUTHORIZED
        );
    }
    @ExceptionHandler(SignOutRestrictedException.class)
    public ResponseEntity<ErrorResponse> signOutRestrictedException(SignOutRestrictedException exe, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exe.getCode()).message(exe.getErrorMessage()), HttpStatus.UNAUTHORIZED
        );
    }

}
