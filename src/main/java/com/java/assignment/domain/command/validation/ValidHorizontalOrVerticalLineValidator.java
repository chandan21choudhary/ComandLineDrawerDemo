package com.java.assignment.domain.command.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.java.assignment.domain.command.DrawLineCommand;

public class ValidHorizontalOrVerticalLineValidator
		implements ConstraintValidator<ValidHorizontalOrVerticalLine, DrawLineCommand> {

	@Override
	public void initialize(ValidHorizontalOrVerticalLine constraintAnnotation) {
	}

	@Override
	public boolean isValid(DrawLineCommand command, ConstraintValidatorContext context) {
		if (command == null) {
			return true;
		}

		return command.getFrom().getX() == command.getTo().getX() || command.getFrom().getY() == command.getTo().getY();
	}
}
