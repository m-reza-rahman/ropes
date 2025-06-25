package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		int initial = 10;

		try {
			initial = Integer.parseInt(args[0]);
			System.out.println("Starting with " + initial + " ropes.");
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("Using default initial 10 ropes.");
		}

		List<Rope> loopedRopes = new ArrayList<>();
		Box box = new Box(IntStream.range(0, initial).mapToObj(r -> new Rope()).collect(Collectors.toList()));

		while (!box.empty()) {
			System.out.println("Picking two rope ends.");

			Rope.End end1 = box.getRandomRopeEnd();
			Rope.End end2 = box.getRandomRopeEnd();

			if (end1.rope() == end2.rope()) {
				System.out.println("Ends of the same rope, so we are trying a loop and removing from the box.");
				Rope rope = end1.rope();
				box.removeRope(rope);
				loopedRopes.add(rope);
			} else {
				System.out.println(
						"Ends of two different ropes, so effectively creating a longer rope by tying the two.");
				Rope rope1 = end1.rope();
				box.removeRope(rope1);
				Rope rope2 = end2.rope();
				box.removeRope(rope2);

				Rope tiedRope = new Rope();
				tiedRope.setLenth(rope1.getLength() + rope2.getLength());
				box.addRope(tiedRope);
			}
		}

		System.out.println("The box is now empty. We have:");
		Map<Integer, Long> counts = loopedRopes.stream()
				.collect(Collectors.groupingBy(r -> r.getLength(), Collectors.counting()));
		counts.forEach((length, count) -> System.out.println(count + " rope(s) of length " + length));
	}
}
