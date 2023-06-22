package model;

public class LineVO {

	private int num;
	private String line;
	
	public LineVO(int num, String line) {
		this.num = num;
		this.line = line;
	}

	// ============================================================================= override
	
	@Override
	public String toString() {
		return this.line;
	}

	// ======================================================================== getter,setter

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
	
}
