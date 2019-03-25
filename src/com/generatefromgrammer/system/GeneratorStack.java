package com.generatefromgrammer.system;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class GeneratorStack {
	private Map<String, List<String>> grammar;
	private final char START_ELEMENT = 'S';
	private boolean console;
	private Stack<char[]> element;
	
	public GeneratorStack(Map<String, List<String>> grammar,boolean console) {
		this.grammar = grammar;
		this.console = console;
	}

	public String generateOneElement() {
		String sentense = "";
		element = getOption(START_ELEMENT);
		int interation = 1;
		while(!element.isEmpty()) {
			char[] local_helper = element.pop();
			char local_character = local_helper[0];
			if(!isNoTerminal(local_character)) {
				sentense += local_character;
			}
			else {
				doIteration(local_character,element);
			}
			
			if(this.console) {
				System.out.println("Interacao " + interation + " = " + element);
			}
			interation++;
		}
		return sentense;
	}


	private boolean isNoTerminal(char c) {
		return ((c >= 'A')&&(c <= 'Z'));
	}

	private void doIteration(char noTerminal, Stack<char[]> element) {
		Stack<char[]> option = getOption(noTerminal);
		while(!option.isEmpty()) {
			element.push(option.pop());
		}
		
		return;
	}

	private Stack<char[]> getOption(char index) {
		Stack<char[]> local_element = new Stack<char[]>();
		List<String> possibilites = grammar.get(""+index);
		Random r = new Random();
		
		int randomOption = r.nextInt()%possibilites.size();
		if(randomOption < 0) {
			randomOption *= -1; // bug negativo
		}
		String option = possibilites.get(randomOption);
		
		for(int i=option.length() - 1;i>=0;i--) {
			char[] local_character = new char[1];
			local_character[0] = option.charAt(i);
			if(local_character[0] == '3') {
				return local_element;
			}
			local_element.push(local_character);
		}
		
		return local_element;
	}
	
}
