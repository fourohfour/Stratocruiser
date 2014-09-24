package io.github.fourohfour.stratocruiser;

import java.util.HashMap;
import java.util.Map;

public class Stratocruiser {
	private static StratocruiserEditor editorInstance;
	
	private static boolean silent = false;
	private static boolean debug = false;
	
	
	public static void main(String[] args){
		Map<String, String> potentialArgs = getPotentialArgs();
		Map<String, Object> parsedArgs = ArgParse.parse(args, potentialArgs);
		
		if(!(parsedArgs.get("debug") == null)){
			debug = (boolean) parsedArgs.get("debug");
		}
		
		if(!(parsedArgs.get("silent") == null)){
		    silent = (boolean) parsedArgs.get("silent");
		}
		
		int x = 800;
		int y = 600;
		
		if(!(parsedArgs.get("windowx") == null)){
			x = (int) parsedArgs.get("windowx");
		}
		
		if(!(parsedArgs.get("windowy") == null)){
			y = (int) parsedArgs.get("windowy");
		}
		
		debug("Creating StratocruiserEditor instance with:");
		debug("x=" + String.valueOf(x));
		debug("y=" + String.valueOf(y));
		
		editorInstance = new StratocruiserEditor(x, y);
	}
	public static void print(String s){
		if(!silent){
		    System.out.println(s);
		}
	}
	
	public static void debug(String s){
		if(!silent){
			if(debug){
				System.out.println(s);
			}
		}
	}
	
	public static Map<String, String> getPotentialArgs(){
		Map<String, String> pArgs = new HashMap<>();
		pArgs.put("debug", "bool");
		pArgs.put("silent", "bool");
		pArgs.put("windowx", "int");
		pArgs.put("windowy", "int");
		return pArgs;
	}
}
