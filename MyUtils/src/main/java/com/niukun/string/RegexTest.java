package com.niukun.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String[] args) {
		String addr = "asdsa123qweds123srere123";
		Pattern pattern = Pattern.compile("(.*)(123)(.*)");
		Matcher matcher = pattern.matcher(addr);
		while(matcher.find()){
			addr = matcher.group(1)+matcher.group(3);
			matcher = pattern.matcher(addr);
			System.out.println(addr);
		}
		System.out.println("uuuu"+addr);
		String newAdd = "asdsa.,/./、123qweds123srere123";
		String splitCharSet = ",、，/.";
		for(int i = 1; i < splitCharSet.length(); i++){
			String splitChar = splitCharSet.substring(i, i + 1);
			if(".".equals(splitChar)){
				newAdd = newAdd.replaceAll("\\.", splitCharSet.substring(0, 1));
			}else{
				newAdd = newAdd.replaceAll(splitChar, splitCharSet.substring(0, 1));
			}
			System.out.println(newAdd);
		}
		newAdd = newAdd.replaceAll(",+", ",");
	}
}
