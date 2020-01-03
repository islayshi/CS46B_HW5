package dna;

//

// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//

public class FastqRecord implements DNARecord {

	private String defline = "";
	private String sequence = "";
	private String quality = "";

	// Be sure to throw RecordFormatException
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException {

		if (defline.charAt(0) != '@') {
			throw new RecordFormatException("Bad 1st char in defline in fastq record: saw X, expected @");
		}

		// initialize instance variables
		this.defline = defline;
		this.sequence = sequence;
		this.quality = quality;

	}

	// returns defline
	public String getDefline() {
		return defline;
	}

	// returns sequence
	public String getSequence() {
		return sequence;
	}

	// returns quality
	public String getQuality() {
		return quality;
	}

	// Checks for deep equality of all 3 instance variables.
	public boolean equals(FastqRecord ob) {
		if (this.defline.equals(ob.getDefline()) && this.sequence.equals(ob.getSequence())
				&& this.quality.equals(ob.getQuality())) {
			return true;
		} else {
			return false;
		}

	}

	// Return true if quality contains at least one '!' char
	// *or at least one '#' char.
	public boolean qualityIsLow() {
		if (quality.contains("!") || quality.contains("#")) {
			return true;
		} else {
			return false;
		}
	}

	// Return the sum of the hash codes of defline, sequence, and quality.
	public int hashCode() {
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();
	}
}
