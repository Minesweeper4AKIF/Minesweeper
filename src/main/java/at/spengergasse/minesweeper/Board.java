package at.spengergasse.minesweeper;


public class Board {
	
	protected int rows, cols;
	private int[][] values;
	
	public Board(int i, int j) {
		if (i > 0) this.rows = i;
		else throw new IllegalArgumentException("Parameter i must be > 0");
		if (j > 0) this.cols = j;
		else throw new IllegalArgumentException("Parameter j must be > 0");
		values = new int[this.rows][this.cols];
	}
	
	public void setValue(int i, int j, int val) {
		if (i < 0 || i > this.rows) throw new IllegalArgumentException("Parameter i invalid");
		if (j < 0 || j > this.cols) throw new IllegalArgumentException("Parameter j invalid");
		this.values[i][j] = val;
	}

	public int getValue(int i, int j) {
		if (i < 0 || i >= this.rows) throw new IllegalArgumentException("Parameter i invalid: " + i);
		if (j < 0 || j >= this.cols) throw new IllegalArgumentException("Parameter j invalid: " + j);
		return this.values[i][j];
	}
	
	public int rows() {
		return rows;
	}
	
	public int cols() {
		return cols;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i=0; i<rows(); i++) {
			for (int j=0; j<cols(); j++) {
				str += getValue(i, j) + " ";
			}
			str += "\n";
		}
		return str;
	}
	
	public void print() {
		System.out.println(this);
	}
}
