package pro.sky.MyArrayList.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@ResponseStatus(value = CONFLICT)
public class IndexOutOfBoundsException extends RuntimeException{
    public IndexOutOfBoundsException(String message){
        super(message);
    }
}
