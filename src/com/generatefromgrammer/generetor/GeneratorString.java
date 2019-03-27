package com.generatefromgrammer.generetor;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

/**
 * @author Roger Vieira
 * @version 1.0
 */
public class GeneratorString {
	private Map<Character, List<String>> grammar;
	private final char START_ELEMENT = 'S';
	private boolean console;
	
	/**
	 * @param grammar
	 * @param a boolean that tells if print in the console in the iterations
	 */
	public GeneratorString(Map<Character, List<String>> grammar,boolean console) {
		this.grammar = grammar;
		this.console = console;
	}

	/**
	 * @return a sentence generator by the grammar.
	 */
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

	/**
	 * @param string
	 * @return if the first element of the string is not terminal
	 */
	private boolean haveNoTerminal(String element) {
		
		for(int i=0;i<element.length();i++) {
			if(element.charAt(i) >= 'A' && element.charAt(i) <= 'Z') {
				return true;
			}
		}
		
		
		return false;
	}
	
	/**
	 * @param full sentence
	 * @return the sentence but if a not terminal substuited by the sentence.
	 */
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
	
	/**
	 * @param character of not terminal
	 * @return a string generate random string using grammar
	 */
	private String getOption(char index) {
		List<String> possibilites = grammar.get(index);
		Random r = new Random();
		
		int randomOption = r.nextInt()%possibilites.size();
		if(randomOption < 0) {
			randomOption *= -1; // bug negativo
		}
		String option = possibilites.get(randomOption);
		
		if(option.equals("3")) {
			return "";
		}
		return option;
	}

}
