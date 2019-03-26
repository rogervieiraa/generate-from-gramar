package com.generatefromgrammer.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderFromFile {
	public static Map<Character, List<String>> readInput(String file_uri) {
		Map<Character, List<String>> ans = new HashMap<Character, List<String>>();
		
		String expression = null;

        try {
            FileReader fileReader = 
                new FileReader(file_uri);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((expression = bufferedReader.readLine()) != null) {
             
        		//remove os espaco
        		expression = eliminateSpace(expression);
        		Character key;
        		List<String> value = new ArrayList<String>();
        		
        		//Primeiro Split
        		String[] divedeNoTerminal = expression.split("=");
        		if(divedeNoTerminal.length != 2) {
        			System.out.println("sem sinal de =");
        		}
        		key = divedeNoTerminal[0].charAt(0);
        		expression = divedeNoTerminal[1];
        		
        		String[] divideOptions = expression.split(";");
        		for(int i=0;i<divideOptions.length;i++) {
        			value.add(divideOptions[i]);
        		}

        		ans.put(key, value);
        		
            }

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado" + file_uri);                
        }
        catch(IOException ex) {
            System.out.println("Erro ao ler o arquivo" + file_uri);                  
            ex.printStackTrace();
        }
		return ans;
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
