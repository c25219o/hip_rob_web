package jp.co.opst.hip_rob.util;

public class StringUtil {

	public static char getLastChar(String word) {
		return word.charAt(word.length() - 1);
	}

	public static boolean isEmpty(String inputWord) {
        return inputWord == null || "".equals(inputWord);
	}

}
