package yiming.model;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

public class ValidateException extends RuntimeException{

    private int errorCode;

    private String message;

    public ValidateException(ConstraintViolationException e) {
        this.errorCode = 400;

        // reason
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder msg = new StringBuilder();
        for (ConstraintViolation<?> violation : violations) {
            msg.append(violation.getPropertyPath()+violation.getMessage()).append(";");
        }
        this.message = msg.toString();
    }

    public ValidateException(String message){
        super(message);
        errorCode=400;
        this.message=message;

    }
}
