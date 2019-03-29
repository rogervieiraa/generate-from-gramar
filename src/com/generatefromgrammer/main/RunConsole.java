package com.generatefromgrammer.main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.generatefromgrammer.generetor.GeneratorStack;
import com.generatefromgrammer.reader.ReaderFromConsole;
import com.generatefromgrammer.reader.ReaderFromFile;

public class RunConsole {
	public static void main(String[] args) {
		System.out.println("Bem vindo ao Generate From Grammar");
		System.out.println("Escolha uma opcao:");
		System.out.println("1 - Digiar Gramatica");
		System.out.println("2 - Importar Gramatica");
		Scanner s = new Scanner(System.in);
		int option = s.nextInt();
		Map<Character, List<String>> grammar;
		if(option == 1) {
			grammar = ReaderFromConsole.readInput();
		}
		else if(option == 2) {
			System.out.println("Digite o local do arquivo:");
			s.nextLine();
			String file_uri = s.nextLine();
			
			grammar = ReaderFromFile.readInput(file_uri);
		}
		else {
			System.out.println("1 OU 2 SABE LER NAO?");
			System.out.println("Brincadeira, executa dinovo ai plz");
			return;
		}
		
		System.out.println("Digite a quantidade de elementos:");
		int quant = s.nextInt();
		System.out.println("Digite:");
		System.out.println("0 - Logs durante o desenvolvimento da sentenca DESATIVADO");
		System.out.println("1 - Logs durante o desenvolvimento da sentenca ATIVADO");
		int conOption = s.nextInt();
		boolean consoleLogs = false;
		if(conOption == 1) {
			consoleLogs = true;
		}
		else if(conOption == 0) {
			consoleLogs = false;
		}
		else {
			System.out.println("0 OU 1 SABE LER NAO?");
			System.out.println("Brincadeira, executa dinovo ai plz");
		}
		
		GeneratorStack gener = new GeneratorStack(grammar, consoleLogs);
		for(int i=1;i<quant + 1;i++) {
			System.out.println(i + " " + gener.generateOneElement());
		}
		
	}
}
