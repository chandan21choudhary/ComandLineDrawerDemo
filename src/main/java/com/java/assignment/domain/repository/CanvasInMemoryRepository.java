package com.java.assignment.domain.repository;

import org.springframework.stereotype.Component;

import com.java.assignment.domain.model.Canvas;

@Component
public class CanvasInMemoryRepository {

	private Canvas canvas = null;

	public void resetCanvas() {
		canvas = null;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}