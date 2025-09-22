package com.abhishek.journalApp;

import java.util.HashMap;
import java.util.Map;

public class Other_CountChar {

	public static void main(String[] args) {


		String input = "hello world";
		
		Map<Character, Integer> charCountMap = new HashMap<>();

		for (char c : input.toCharArray()) {
			
			if(c == ' ') continue;
			
			charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
		}
		
		for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

}
