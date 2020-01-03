package dna;

import java.io.*;
import java.util.*;

public class FileConverter {
	private File fastq;
	private File fasta;

	public FileConverter(File fastq, File fasta) {
		this.fastq = fastq;
		this.fasta = fasta;
	}

	//
	// Writes a fasta file consisting of conversion of all records from the fastq
	// with sufficient quality and unique defline.
	//

	public void convert() throws IOException {

		// Build chain of readers.
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Build chain of writers.
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);

		// Read, translate, write.

		/*
		 * Read each fastq record until the end of the fastq file is reached. Do nothing
		 * with invalid records. (defline isn't @) If the quality isn't low, create a
		 * fasta record and write it using the FastaWriter
		 */

		FastqRecord myLine = null;
		try {
			myLine = fqr.readRecord();
		} catch (RecordFormatException rfe) {

		}

		while (myLine != null) {
			if ((!myLine.qualityIsLow()) && (myLine.getDefline().substring(0, 1).equals("@"))) {
				faw.writeRecord(new FastaRecord(myLine));
			}
		}

		// Close fr, br, fw, and pw in reverse order of creation.

		pw.close();
		fw.close();
		br.close();
		fr.close();
	}

	public static void main(String[] args) {
		System.out.println("Starting");
		try {
			File fastq = new File("data/HW5.fastq");
			if (!fastq.exists()) {
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW5.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		} catch (IOException x) {
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
