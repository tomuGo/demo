package yiming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yiming.model.ValidateException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ValidatorService {
    @Autowired
    private Validator validator;

    public <T> void validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for(ConstraintViolation<T> violation:constraintViolations){
                msg.append(violation.getMessage()).append(";");
            }

            throw new ValidateException(msg.toString());
        }
    }

    public <T> void validateProperty(T object, String propertyName, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validateProperty(object, propertyName, groups);
        if (!constraintViolations.isEmpty()) {
            throw new RuntimeException(new ConstraintViolationException(constraintViolations));
        }
    }
}
