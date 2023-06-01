package com.example.RestTemplatePracatice.GlobalException;

import com.example.RestTemplatePracatice.Entity.ApiRes1;
import org.springframework.beans.MethodInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalException {
    @Autowired
    private ApiRes1 apiRes1;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiRes1> handleMethodArgumentsNotFoundException(MethodArgumentNotValidException e){
        HashMap<String, Object> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((error) ->{
            String fieldError = error.getField();
            String message = error.getDefaultMessage();
            errors.put(fieldError,message);
            apiRes1.setData(null);
            apiRes1.setStatus(errors);
            apiRes1.setMessage("Something Went To Wrong");
        });
        return new ResponseEntity<ApiRes1>((MultiValueMap<String, String>) e.getBody(),HttpStatus.BAD_REQUEST);
    }
@ExceptionHandler(NotSatisfiedException.class)
    public ApiRes1 notSatisfiedException(NotSatisfiedException e){
            apiRes1.setData(null);
            apiRes1.setStatus(HttpStatus.NOT_FOUND);
            apiRes1.setMessage("NotFound Exception");
            return apiRes1;
}
    @ExceptionHandler(MethodArgumentsNotFoundException.class)
    public ApiRes1 methodArgumentsNotFoundException(MethodArgumentsNotFoundException e){
        apiRes1.setData(null);
        apiRes1.setStatus(HttpStatus.METHOD_NOT_ALLOWED);
        apiRes1.setMessage("NotFound Exception");
        return apiRes1;
    }

//    @ExceptionHandler(Exception.class)
//    public ApiRes1 methodArgumentsNotFoundException(Exception e){
//        apiRes1.setData(null);
//        apiRes1.setStatus(HttpStatus.NOT_FOUND);
//        apiRes1.setMessage("NotFound Exception");
//        return apiRes1;
//    }
}
