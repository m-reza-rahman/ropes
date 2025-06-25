package com.example;

public class Rope {
	private static final int UNIT_LENGTH = 1;

	private int length;
	private End end = null;

	public Rope() {
		length = UNIT_LENGTH;
		end = new End(this);
	}
	
	public Rope(int length) {
		this.length = length;
		end = new End(this);
	}

	public int getLength() {
		return length;
	}

	public End getEnd() {
		return end;
	}

	public record End(Rope rope) {
	}
}
