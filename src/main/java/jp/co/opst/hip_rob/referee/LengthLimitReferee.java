package jp.co.opst.hip_rob.referee;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LengthLimitReferee extends StandardReferee {

	private int minLimit;

	public void setMinLimit(int minLimit) {
		this.minLimit = minLimit;
	}

	@Override
	public String findOkWord(List<String> computerWords) {
		for (String word : computerWords) {
			if (!alreadyInput(word) && !lengthInvalid(word)) {
				return word;
			}
		}
		return null;
	}

	public boolean lengthInvalid(String current) {
		return current.length() > minLimit;
	}
}
