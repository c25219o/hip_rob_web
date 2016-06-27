package jp.co.opst.hip_rob.referee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StandardReferee {

    private List<String> alreadyList = new ArrayList<>();

    public void remember(String word) {
        alreadyList.add(word);
    }

	public boolean alreadyInput(String word) {
		return alreadyList.contains(word);
    }

    public void forget() {
        alreadyList = new ArrayList<>();
    }

	public List<String> all() {
		return alreadyList;
	}

}
