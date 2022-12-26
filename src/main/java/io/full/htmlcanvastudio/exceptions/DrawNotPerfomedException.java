package io.full.htmlcanvastudio.exceptions;

public class DrawNotPerfomedException extends RuntimeException{

	public DrawNotPerfomedException() {
        super("Caught exception while trying to draw a shape in canvas");
    }
}
