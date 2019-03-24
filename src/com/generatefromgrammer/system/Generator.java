package com.generatefromgrammer.system;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Generator {
	private Map<String, List<String>> grammar;
	private final char START_ELEMENT = 'S';
	private boolean console;
	
	public Generator(Map<String, List<String>> grammar,boolean console) {
		this.grammar = grammar;
		this.console = console;
	}

	public String generateOneElement() {
		String element = getOption(START_ELEMENT);
		int interation = 1;
		while(haveNoTerminal(element)) {
			element = doIteration(element);
			if(this.console) {
				System.out.println("Interacao " + interation + " = " + element);
			}
			interation++;
		}
		return element;
	}

	private boolean haveNoTerminal(String element) {
		
		for(int i=0;i<element.length();i++) {
			if(element.charAt(i) >= 'A' && element.charAt(i) <= 'Z') {
				return true;
			}
		}
		
		
		return false;
	}

	private String doIteration(String element) {
		String ans = "";
		boolean alreadyDidNoTerminal = false;
		for(int i=0;i<element.length();i++) {
			if(alreadyDidNoTerminal) {
				ans += element.charAt(i);
			}
			else {
				if(element.charAt(i) >= 'A' && element.charAt(i) <= 'Z') {

					ans += getOption(element.charAt(i));
				}
				else {
					ans += element.charAt(i);
				}
			}
		}
		
		return ans;
		
	}

	private String getOption(char index) {
		List<String> possibilites = grammar.get(""+index);
		Random r = new Random();
		
		int randomOption = r.nextInt()%possibilites.size();
		if(randomOption < 0) {
			randomOption *= -1; // bug negativo
		}
		return possibilites.get(randomOption);
	}
}
