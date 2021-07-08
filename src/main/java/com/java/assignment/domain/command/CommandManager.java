package com.java.assignment.domain.command;

import java.util.Stack;

import com.java.assignment.domain.command.validation.CommandValidationException;
import com.java.assignment.domain.model.CanvasRedrawException;

public class CommandManager {
    private final Stack<DrawingCommand> history = new Stack<>();
    private final Stack<DrawingCommand> redoBuffer = new Stack<>();

    public void executeCommand(DrawingCommand command) throws CommandValidationException {
        history.push(command);
        command.validateAndExecute();
    }

    public void undo() throws CanvasRedrawException {
        if(!history.empty()){
            DrawingCommand command = history.pop();
            redoBuffer.push(command);

            command.undo();
        }
    }

    public void redo() throws CommandValidationException {
        if(!redoBuffer.isEmpty()){
            DrawingCommand command = redoBuffer.pop();

            executeCommand(command);
        }
    }
}