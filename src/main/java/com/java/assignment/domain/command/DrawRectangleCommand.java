package com.java.assignment.domain.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.java.assignment.domain.command.validation.ValidPointsInCanvas;
import com.java.assignment.domain.model.Canvas;
import com.java.assignment.domain.model.Point;

@ValidPointsInCanvas(message = "One or more points are outside the canvas")
public class DrawRectangleCommand extends DrawingCommand {
    private final Point from;
    private final Point to;

    public DrawRectangleCommand(Canvas canvas, Point from, Point to) {
        super(canvas);
        this.from = from;
        this.to = to;
    }

    @Override
    public void executeSpecific() {
        List<DrawingCommand> subCommands = new ArrayList<>();
        subCommands.add(new DrawLineCommand(canvas, from, new Point(from.getX(), to.getY())));
        subCommands.add(new DrawLineCommand(canvas, from, new Point(to.getX(), from.getY())));
        subCommands.add(new DrawLineCommand(canvas, to, new Point(from.getX(), to.getY())));
        subCommands.add(new DrawLineCommand(canvas, to, new Point(to.getX(), from.getY())));

        subCommands.forEach(DrawingCommand::execute);
    }

    @Override
    public Collection<Point> getPoints() {
        return Arrays.asList(from, to);
    }
}