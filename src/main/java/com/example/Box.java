package com.example;

import java.util.List;
import java.util.Random;

public class Box {

	private Random random = new Random();
	private List<Rope> ropes = null;

	public Box(List<Rope> ropes) {
		this.ropes = ropes;
	}

	public Rope.End getRandomRopeEnd() {
		return ropes.get(random.nextInt(ropes.size())).getEnd();
	}

	public boolean empty() {
		return ropes.isEmpty();
	}

	public void addRope(Rope rope) {
		ropes.add(rope);
	}

	public void removeRope(Rope rope) {
		ropes.remove(rope);
	}
}
