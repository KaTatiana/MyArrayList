package pro.sky.MyArrayList.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@ResponseStatus(value = CONFLICT)
public class IllegalArgumentException extends RuntimeException{
    public IllegalArgumentException(String message){
        super(message);
    }
}
