package dna;

import java.io.*;

//
// Reads lines from a BufferedReader and builds a FastqRecord.
//

public class FastqReader {

	BufferedReader theBufferedReader;

	public FastqReader(BufferedReader theBufferedReader) {
		this.theBufferedReader = theBufferedReader;

	}

	// Returns next record in the file, or null if EOF (end-of-file).
	public FastqRecord readRecord() throws IOException, RecordFormatException {
		// Read the defline from the BufferedReader.
		// If a null is read then it indicates the EOF

		if (theBufferedReader.readLine() == null) {
			return null;
		}

		// Read the next 3 lines from the buffered reader. Construct and return
		// a FastqRecord.

		String defline = theBufferedReader.readLine();
		String sequence = theBufferedReader.readLine();
		String quality = theBufferedReader.readLine();
		FastqRecord ob = new FastqRecord(defline, sequence, quality);

		return ob;

	}
}
