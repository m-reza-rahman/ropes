package com.example;

public class Rope {
	private static final int UNIT_LENGTH = 1;

	private int length = UNIT_LENGTH;
	private End end = null;

	public Rope() {
		end = new End(this);
	}

	public int getLength() {
		return length;
	}

	public void setLenth(int length) {
		this.length = length;
	}

	public End getEnd() {
		return end;
	}

	public record End(Rope rope) {
	}
}
