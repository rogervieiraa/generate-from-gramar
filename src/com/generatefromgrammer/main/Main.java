package com.generatefromgrammer.main;

import java.util.List;
import java.util.Map;

import com.generatefromgrammer.system.GeneratorString;
import com.generatefromgrammer.system.GeneratorStack;
import com.generatefromgrammer.system.Reader;

public class Main {

	public static void main(String[] args) {
		
		Map<String, List<String>> grammar = Reader.readInput();
		System.out.println("S" + grammar.get("S"));
		
		GeneratorString gen = new GeneratorString(grammar, false);
		for(int i=0;i<3;i++) {
			System.out.println(i + " " + gen.generateOneElement());
		}
		GeneratorStack genner = new GeneratorStack(grammar, false);
		for(int i=0;i<3;i++) {
			System.out.println(i + " " + genner.generateOneElement());
		}
		
	}

}
