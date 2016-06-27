package jp.co.opst.hip_rob.param;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.opst.hip_rob.util.StringUtil;

public class InputWord {

	private String previous;

	@NotBlank(message = "からっぽだよ")
	private String current;

	@AssertTrue(message = "しりとりのルールまもれ")
	public boolean isValid() {
		return StringUtil.isEmpty(previous) ? true : StringUtil.getLastChar(previous) == current.charAt(0);
	}

	/**
	 * @return the previous
	 */
	public String getPrevious() {
		return previous;
	}

	/**
	 * @param previous
	 *            the previous to set
	 */
	public void setPrevious(String previous) {
		this.previous = previous;
	}

	/**
	 * @return the current
	 */
	public String getCurrent() {
		return current;
	}

	/**
	 * @param current
	 *            the current to set
	 */
	public void setCurrent(String current) {
		this.current = current;
	}

}
