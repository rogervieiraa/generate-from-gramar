package com.generatefromgrammer.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Reader {
	
	//salva os Nao Terminais
	private static Map<String, List<String>> answer;
	//Salva os n�o terminais que ainda n�o foram lidos
	private static List<String> queueReader;
	
	public static Map<String, List<String>> readInput() {
		answer = new HashMap<String, List<String>>();
		queueReader = new ArrayList<String>();
		
		Scanner inputReader = new Scanner(System.in);
		
		String first = inputReader.nextLine();
		
		addToMap(first);
		executeQueue();
		return answer;
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
	
	//Adiciona no mape chama o addToQueue
	private static void addToMap(String expression) {
		//remove os espaco
		expression = eliminateSpace(expression);
		String key = "";
		List<String> value = new ArrayList<String>();
		
		//Primeiro Split
		String[] divedeNoTerminal = expression.split("=");
		if(divedeNoTerminal.length != 2) {
			System.out.println("sem sinal de =");
			return;
		}
		key = divedeNoTerminal[0];
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
			if(expression.charAt(i) >= 'A' && expression.charAt(i) <= 'Z') {
				
				if(!queueReader.contains("" + expression.charAt(i))) {
					queueReader.add("" + expression.charAt(i));
				}
				
			}
		}
		
		
	}
	
	//le o proximo elemento
	private static String readLine(String expected) {
		Scanner s = new Scanner(System.in);
		System.out.println("Insera nao terminal " + expected +" seguindo padrao X = xxxx");
		
		return eliminateSpace(s.nextLine());
	}
	
	//executa a queue
	private static void executeQueue() {
		for(int i=0;i<queueReader.size();i++) {
			String ans = readLine(queueReader.get(i));
			addToMap(ans);
		}
	}
	
}
