package com.java.assignment.domain.command;

import java.util.Collection;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

import com.java.assignment.domain.command.validation.CommandValidationException;
import com.java.assignment.domain.model.Canvas;
import com.java.assignment.domain.model.CanvasRedrawException;
import com.java.assignment.domain.model.Point;


public abstract class DrawingCommand {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @NotNull(message = "Canvas has to be initialized first")

    protected final Canvas canvas;

    private Canvas history;

    public abstract Collection<Point> getPoints();

    public DrawingCommand(Canvas canvas){
        this.canvas = canvas;
    }

    public final void validateAndExecute() throws CommandValidationException {
        validate();
        execute();
    }

    private void validate() throws CommandValidationException {
        Set<ConstraintViolation<DrawingCommand>> violations = validator.validate(this);
        if(!violations.isEmpty())
            throw new CommandValidationException(violations, "DrawingCommand is invalid");
    }

    public final void execute(){
        history = canvas.duplicate();
        executeSpecific();
    }

    abstract void executeSpecific();

    public void undo() throws CanvasRedrawException {
        if(history != null)
            canvas.redraw(history);
    }

	public Canvas getCanvas() {
		return canvas;
	}

    
}
