package com.java.assignment.domain.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.java.assignment.domain.model.Canvas;
import com.java.assignment.domain.model.Pixel;
import com.java.assignment.domain.model.Point;

public class BucketFillCommand extends DrawingCommand {
    private final Point from;
    private final char replacementColor;

    public BucketFillCommand(Canvas canvas, Point from, char replacementColor){
        super(canvas);
        this.from = from;
        this.replacementColor = replacementColor;
    }

    @Override
    public void executeSpecific() {
        char originalColor = canvas.getPixel(from).getColor();

        if(originalColor == replacementColor)
            return;

        Queue<Point> queue = new LinkedList<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            Point current = queue.remove();
            canvas.setPixel(current, new Pixel(replacementColor));

            List<Point> neighbors = new ArrayList<>();
            neighbors.add(new Point(current.getX() - 1, current.getY()));
            neighbors.add(new Point(current.getX() + 1, current.getY()));
            neighbors.add(new Point(current.getX(), current.getY() - 1));
            neighbors.add(new Point(current.getX(), current.getY() + 1));

            neighbors.forEach(point -> {
                if (point.getX() > 0 && point.getX() <= canvas.getWidth()
                        && point.getY() > 0 && point.getY() <= canvas.getHeight()
                        && canvas.getPixel(point).getColor() == originalColor){
                    queue.add(point);
                }
            });

        }
    }

    @Override
    public Collection<Point> getPoints() {
        return Collections.singletonList(from);
    }
}
