package com.generatefromgrammer.generetor;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

/**
 * @author Roger Vieira
 * @version 1.1
 */
public class GeneratorStack {
	private Map<Character, List<String>> grammar;
	private final char START_ELEMENT = 'S';
	private boolean console;
	private Stack<Character> elements;
	
	/**
	 * @param grammar
	 * @param a boolean that tells if print in the console in the iterations
	 */
	public GeneratorStack(Map<Character, List<String>> grammar,boolean console) {
		this.grammar = grammar;
		this.console = console;
		
	}
	
	public String generateOneElement() {
		this.elements = new Stack<Character>();
		this.elements.push(this.START_ELEMENT);
		String sentense = "";
		int interation = 1;
		while(!this.elements.isEmpty()) {
			Character local_char = elements.pop();
			if(isNoTerminal(local_char)) {
				addOption(local_char);
				//doIteration(local_char);
			}
			else {
				sentense += local_char;
			}
			if(this.console) {
				System.out.println("Interation: " + interation);
				System.out.println("Sentense: " + sentense);
				interation++;
			}
		}
		return sentense;
	}
	
	/**
	 * @param string
	 * @return if the character is not terminal
	 */
	private boolean isNoTerminal(Character character) {
			return (character >= 'A' && character <= 'Z');
	}

	/**
	 * @param character of not terminal
	 */
	private void addOption(char index) {
		List<String> possibilites = grammar.get(index);
		Random r = new Random();
		
		int randomOption = r.nextInt()%possibilites.size();
		if(randomOption < 0) {
			randomOption *= -1; // bug negativo
		}
		String option = possibilites.get(randomOption);
		
		if(option.equals("3")) {
			option = "";
		}
		
		for(int i=option.length() - 1;i>=0;i--) {
			this.elements.push(option.charAt(i));
		}
		
	}
	
	/**
	 * @deprecated
	 * @param character of the Not Terminal
	 */
	private void doIteration(Character local_char) {
		Stack<Character> auxiliarStack = getOption(local_char);
		
		while(!auxiliarStack.isEmpty()) {
			this.elements.push(auxiliarStack.pop());
		}
		
	}
	
	/**
	 * @param character of not terminal
	 * @deprecated
	 * @return a string generate random string using grammar
	 */
	private Stack<Character> getOption(char index) {
		List<String> possibilites = grammar.get(index);
		Random r = new Random();
		
		int randomOption = r.nextInt()%possibilites.size();
		if(randomOption < 0) {
			randomOption *= -1; // bug negativo
		}
		String option = possibilites.get(randomOption);
		
		if(option.equals("3")) {
			option = "";
		}
		Stack<Character> ans = new Stack<Character>();
		// i ++ pq vai ser desempilhado e empilhado denovo
		for(int i=0;i<option.length();i++) {
			ans.push(option.charAt(i));
		}
		
		return ans;
	}
	
}
