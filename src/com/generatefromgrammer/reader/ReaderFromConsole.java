package com.generatefromgrammer.reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ReaderFromConsole {
	
	//salva os Nao Terminais
	private static Map<Character, List<String>> answer;
	//Salva os n�o terminais que ainda n�o foram lidos
	private static List<Character> queueReader;
	
	public static Map<Character, List<String>> readInput() {
		answer = new HashMap<Character, List<String>>();
		queueReader = new ArrayList<Character>();
		
		Scanner inputReader = new Scanner(System.in);
		
		String first = inputReader.nextLine();

		addToMap(first);
		executeQueue();
		return answer;
	}
	
	//Adiciona no mape chama o addToQueue
	private static void addToMap(String expression) {
		//remove os espaco
		expression = eliminateSpace(expression);
		Character key;
		List<String> value = new ArrayList<String>();
		
		//Primeiro Split
		String[] divedeNoTerminal = expression.split("=");
		if(divedeNoTerminal.length != 2) {
			System.out.println("sem sinal de =");
			return;
		}
		key = divedeNoTerminal[0].charAt(0);
		expression = divedeNoTerminal[1];
		
		String[] divideOptions = expression.split(";");
		for(int i=0;i<divideOptions.length;i++) {
			addToQueue(divideOptions[i]);
			value.add(divideOptions[i]);
		}

		answer.put(key, value);
		
	}
	
	//Adiciona na Queue
	private static void addToQueue(String expression) {
		for(int i=0;i<expression.length();i++) {
			if((expression.charAt(i) >= 'A') && 
					(expression.charAt(i) <= 'Z')&&
					(expression.charAt(i) != 'S')) {
				
				if(!queueReader.contains(expression.charAt(i))) {
					queueReader.add(expression.charAt(i));
				}
				
			}
		}
		
		
	}
	
	//executa a queue
	private static void executeQueue() {
		for(int i=0;i<queueReader.size();i++) {
			String ans = readLine(queueReader.get(i));
			addToMap(ans);
		}
	}
	
	//le o proximo elemento
	private static String readLine(Character expected) {
		Scanner s = new Scanner(System.in);
		System.out.println("Insera nao terminal " + expected +" seguindo padrao X = xX ; xx");
		String line = s.nextLine();
		return eliminateSpace(line);
	}
	
	//Remove os espacos
	private static String eliminateSpace(String expression) {
		String ans = "";
		
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i) != ' ') {
				ans += expression.charAt(i);
			}
		}
		return ans;
	}
	
}
