package com.generatefromgrammer.main;

import java.util.List;
import java.util.Map;

import com.generatefromgrammer.system.Generator;
import com.generatefromgrammer.system.Reader;

public class Main {

	public static void main(String[] args) {
		
		Map<String, List<String>> grammar = Reader.readInput();
		System.out.println("S" + grammar.get("S"));
		
		Generator gen = new Generator(grammar, false);
		for(int i=0;i<10;i++) {
			System.out.println(i + " " + gen.generateOneElement());
		}
		
		
	}

}
