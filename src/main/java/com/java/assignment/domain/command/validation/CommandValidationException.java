package com.java.assignment.domain.command.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.java.assignment.domain.command.DrawingCommand;

public class CommandValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	private final Set<ConstraintViolation<DrawingCommand>> violations;

	public CommandValidationException(Set<ConstraintViolation<DrawingCommand>> violations, String message) {
		super(message);
		this.violations = violations;
	}

	public Set<ConstraintViolation<DrawingCommand>> getViolations() {
		return violations;
	}

}