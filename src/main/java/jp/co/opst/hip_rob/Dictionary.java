package jp.co.opst.hip_rob;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Dictionary {
	private List<String> myWordsList;

	public Dictionary() {
		myWordsList = new ArrayList<String>();
		myWordsList.add("あずき");
		myWordsList.add("いんこ");
		myWordsList.add("うちゅう");
		myWordsList.add("えだまめ");
		myWordsList.add("おとな");
		myWordsList.add("かき");
		myWordsList.add("きつね");
		myWordsList.add("くも");
		myWordsList.add("けしごむ");
		myWordsList.add("こども");
		myWordsList.add("さとう");
		myWordsList.add("しずく");
		myWordsList.add("せみ");
		myWordsList.add("そうじ");
		myWordsList.add("たんぼ");
		myWordsList.add("ちず");
		myWordsList.add("つくね");
		myWordsList.add("てがみ");
		myWordsList.add("ともだち");
		myWordsList.add("なぞ");
		myWordsList.add("にんじゃ");
		myWordsList.add("ぬりえ");
		myWordsList.add("ねこ");
		myWordsList.add("のり");
		myWordsList.add("はまべ");
		myWordsList.add("ひつじ");
		myWordsList.add("ふぶき");
		myWordsList.add("へちま");
		myWordsList.add("ほととぎす");
		myWordsList.add("まつり");
		myWordsList.add("みみず");
		myWordsList.add("むつごろう");
		myWordsList.add("めだか");
		myWordsList.add("もり");
		myWordsList.add("やたい");
		myWordsList.add("ゆず");
		myWordsList.add("よる");
		myWordsList.add("らじお");
		myWordsList.add("りす");
		myWordsList.add("るり");
		myWordsList.add("れご");
		myWordsList.add("ろうそく");
		myWordsList.add("わた");
	}

	public List<String> lookup(char prefix) {
		List<String> wordList = new ArrayList<>();
		for (String str : myWordsList) {
			if (str.charAt(0) == prefix) {
				wordList.add(str);
			}
		}
		return wordList;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		while (true) {
			String word = scanner.next();
			if ("ok".equalsIgnoreCase(word))
				break;
			list.add("insert into word_list (word) values (\'" + word + "\');");
		}
		list.forEach(System.out::println);
	}

}
