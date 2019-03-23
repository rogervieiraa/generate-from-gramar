package com.generatefromgrammer.main;

import java.util.List;
import java.util.Map;

import com.generatefromgrammer.system.Reader;

public class Main {

	public static void main(String[] args) {
		
		Map<String, List<String>> grammar = Reader.readInput();
		grammar = Reader.readInput();
		System.out.println(grammar.get("S"));
	}

}
