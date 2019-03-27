package com.generatefromgrammer.main;

import java.util.List;
import java.util.Map;

import com.generatefromgrammer.generetor.GeneratorStack;
import com.generatefromgrammer.generetor.GeneratorString;
import com.generatefromgrammer.reader.ReaderFromConsole;
import com.generatefromgrammer.reader.ReaderFromFile;

public class Main {

	public static void main(String[] args) {
		
		//Map<Character, List<String>> grammar = ReaderFromConsole.readInput();
		Map<Character, List<String>> grammar = ReaderFromFile.readInput("example/ex3.txt");
		GeneratorString gen = new GeneratorString(grammar, false);
		for(int i=0;i<5;i++) {
			System.out.println(i + " " + gen.generateOneElement());
		}
		GeneratorStack gener = new GeneratorStack(grammar, false);
		for(int i=0;i<5;i++) {
			System.out.println(i + " " + gener.generateOneElement());
		}
		
	}

}
