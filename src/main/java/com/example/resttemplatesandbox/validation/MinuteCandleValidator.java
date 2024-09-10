package com.example.resttemplatesandbox.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MinuteCandleValidator implements Validator {
    private List<Integer> allowedUnit = new ArrayList<>();

    MinuteCandleValidator() {
        allowedUnit.add(1);
        allowedUnit.add(3);
        allowedUnit.add(5);
        allowedUnit.add(10);
        allowedUnit.add(15);
        allowedUnit.add(30);
        allowedUnit.add(60);
        allowedUnit.add(240);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Integer.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Integer unit = (Integer) target;

        if(!allowedUnit.contains(unit)) {
            errors.rejectValue("unit", "invalid unit");
        }
    }
}
