package com.ugurhmz.customAnnotation;


import com.ugurhmz.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@RequiredArgsConstructor
public final class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    private final UserRepository userRepository;


    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsUserByUserName(userName);
    }
}
