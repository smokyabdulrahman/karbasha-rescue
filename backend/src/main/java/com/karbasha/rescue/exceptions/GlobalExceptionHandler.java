package com.karbasha.rescue.exceptions;

import org.springframework.http.*;
import org.springframework.security.access.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(getErrorResponse(ex, "Record Not Found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public final ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        return new ResponseEntity<>(getErrorResponse(ex, "Requester is not authorized to access this resource"),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(getErrorResponse(ex, "Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static ErrorResponse getErrorResponse(Exception ex, String message) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        return new ErrorResponse(message, details);
    }
}