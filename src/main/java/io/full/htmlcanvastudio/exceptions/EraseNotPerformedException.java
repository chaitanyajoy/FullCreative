package io.full.htmlcanvastudio.exceptions;

public class EraseNotPerformedException extends RuntimeException{
	
	public EraseNotPerformedException() {
        super("Caught exception while trying to erase a shape in canvas");
    }
}
