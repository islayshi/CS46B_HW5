package dna;

public class FastaRecord implements DNARecord {
	private String defline = "";
	private String sequence = "";

	//
	// Throw RecordGFormatException if the 1st char of the defline is not '>'.
	public FastaRecord(String defline, String sequence) throws RecordFormatException {
		if (defline.charAt(0) != '>') {
			throw new RecordFormatException("defline doesn't begin with >");
		}

		this.defline = defline;
		this.sequence = sequence;

	}

	// Initialize defline and sequence from the input record.
	public FastaRecord(FastqRecord fastqRec) {

		// substring(1) will return defline from index 1 to the end

		this.defline = ">" + fastqRec.getDefline().substring(1);
		this.sequence = fastqRec.getSequence();

	}

	// returns defline
	public String getDefline() {
		return defline;
	}

	// returns sequence
	public String getSequence() {
		return sequence;
	}

	// Check if objects are equal by comparing defline and sequence
	public boolean equals(FastaRecord ob) {
		if (this.defline.equals(ob.getDefline()) && this.sequence.equals(ob.getSequence())) {
			return true;
		} else {
			return false;
		}
	}

	// Returns the sum of the hashcodes of defline and sequence.
	public int hashCode() {
		return defline.hashCode() + sequence.hashCode();
	}
}
