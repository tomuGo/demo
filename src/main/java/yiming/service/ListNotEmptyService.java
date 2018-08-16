package yiming.service;

import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Service
public class ListNotEmptyService implements ConstraintValidator<ListNotEmpty, List> {

    public void initialize(ListNotEmpty constraintAnnotation) {

    }

    public boolean isValid(List value, ConstraintValidatorContext context) {
        if(value==null||value.size()==0){
            return false;
        }
        return true;
    }
}
