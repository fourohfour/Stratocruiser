package io.github.fourohfour.stratocruiser;

import java.util.HashMap;
import java.util.Map;

public class ArgParse {
	public static Map<String, Object> parse(String[] args, Map<String, String> expect) {
		Map<String, Object> returnmap = new HashMap<>();
		for(String arg : args){
			String s = arg.replaceAll(" ", "");
			String[] kv = s.split("=");
			if(kv.length == 2){
				String key = kv[0];
				String value = kv[1];
				String valtype = expect.get(key);
				if(valtype == null){
					valtype = "str";
				}
				
				if(valtype == "str"){
				    returnmap.put(key, value);
				}
				else if (valtype == "int"){
					try{
					    returnmap.put(key, Integer.parseInt(value));
					}
					catch(NumberFormatException e){
						Stratocruiser.print("Error for argument: " + arg);
						Stratocruiser.print("Error: Expected integer, could not parse.");
					}
				}
				else if (valtype == "float"){
					try{
					    returnmap.put(key, Float.parseFloat(value));
					}
					catch(NumberFormatException e){
						Stratocruiser.print("Error for argument: " + arg);
						Stratocruiser.print("Error: Expected float, could not parse.");
					}
				}
				else if (valtype == "bool"){
					returnmap.put(key, Boolean.parseBoolean(value));
				}
				
			}
			else{
				Stratocruiser.print("Error for argument: " + arg);
				Stratocruiser.print("Error: Could not parse.");
				Stratocruiser.debug("When split on '=' characters, the length of the resulting array was not 2.");
			}
		}
		return returnmap;
	}
}
