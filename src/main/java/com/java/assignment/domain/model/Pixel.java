package com.java.assignment.domain.model;

public class Pixel {

	    private final char color;

	    public Pixel(Pixel copy){
	        this.color = copy.color;
	    }
	    
	    public Pixel(char copy){
	        this.color = copy;
	    }

	    public Pixel duplicate(){
	        return new Pixel(this);
	    }

		/**
		 * @return the color
		 */
		public char getColor() {
			return color;
		}

		
	}