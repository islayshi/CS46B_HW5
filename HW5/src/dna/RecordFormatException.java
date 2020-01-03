package dna;

public class RecordFormatException extends Exception {

	/*
	 * Should extend Exception. Constructor should take a String arg and pass the
	 * String to the superclass constructor that takes a single String ag.
	 */
	public RecordFormatException(String message) {
		// This way the arg becomes the exception's message
		// The exception handler can grab it by calling getMessage()

		super(message);

	}

}
