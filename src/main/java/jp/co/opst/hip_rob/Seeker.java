package jp.co.opst.hip_rob;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Seeker {

	@Autowired
	private Dictionary dictionary;

	private List<String> foundWords = new ArrayList<>();

	public boolean seek(String current) {
		foundWords = dictionary.lookup(current.charAt(current.length() - 1));
		return !foundWords.isEmpty();
	}

	public List<String> get() {
		return foundWords;
	}

}
