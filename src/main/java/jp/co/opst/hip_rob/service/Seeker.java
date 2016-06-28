package jp.co.opst.hip_rob.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.opst.hip_rob.dao.WordListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Seeker {

	@Autowired
	private WordListDao dao;

	public List<String> seek(String current) {
		List<String> foundWords = lookup(current.charAt(current.length() - 1));
		return foundWords;
	}

	private List<String> lookup(char prefix) {
		List<String> wordList = new ArrayList<>();
		for (String str : dao.all()) {
			if (str.charAt(0) == prefix) {
				wordList.add(str);
			}
		}
		return wordList;
	}

}
