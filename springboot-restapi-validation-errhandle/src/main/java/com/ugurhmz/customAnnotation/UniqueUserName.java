package com.ugurhmz.customAnnotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;




@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { UniqueUserNameValidator.class })
public @interface UniqueUserName {

    String message() default "{rest-api-project3.constraints.UniqueUserName.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
