package com.joshua.spring.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
//��ܸ�Annotation�����Ϊ���m
@Target({ ElementType.METHOD, ElementType.FIELD })
//��eAnnotation���O�d����:RUNTIME
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
	String message() default "{Phone}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
