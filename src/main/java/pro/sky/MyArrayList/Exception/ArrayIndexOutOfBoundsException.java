package pro.sky.MyArrayList.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@ResponseStatus(value = CONFLICT)
public class ArrayIndexOutOfBoundsException extends RuntimeException {
    public ArrayIndexOutOfBoundsException(String message){
        super(message);
    }
}
