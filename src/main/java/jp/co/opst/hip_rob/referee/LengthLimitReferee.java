package jp.co.opst.hip_rob.referee;

public class LengthLimitReferee extends StandardReferee {

	private int minLimit;

	public LengthLimitReferee(int minLimit) {
		this.minLimit = minLimit;
	}

	public boolean isLengthOk(String word) {
		return word.length() >= minLimit;
	}
}
