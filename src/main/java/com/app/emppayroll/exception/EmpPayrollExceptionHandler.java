package com.app.emppayroll.exception;

import com.app.emppayroll.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

// Provide ability to handle all exception at one place.
@ControllerAdvice
@Slf4j
public class EmpPayrollExceptionHandler {

    // Defining a String constant.
    private static final String MSG = "Exception while processing REST request!";

    // Used to handle specific exception and to send customized response to client.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgNotValidException(MethodArgumentNotValidException exception) {

        // To get all errors in list.
        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();

        // Applying stream API.
        // Converting list of ObjectError to list of String.
        List<String> errMsg = allErrors.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());

        ResponseDto responseDto = new ResponseDto("Exception while processing rest request!", errMsg);

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    // Handle exception which are throws manually from service class.
    @ExceptionHandler(EmpPayrollException.class)
    public ResponseEntity<ResponseDto> handleEmpPayrollException(EmpPayrollException exception) {

        ResponseDto responseDto = new ResponseDto("Exception while processing employee request!", exception.getMessage());
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }

    // Handling exception for incorrect date format.
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> handleHttpMsgNotReadableException(HttpMessageNotReadableException exception) {
        log.error("Invalid Date Format!", exception);

        ResponseDto responseDto = new ResponseDto(MSG, "Should have date in the format dd MMM yyyy!");
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}