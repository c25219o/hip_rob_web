package jp.co.opst.hip_rob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YetController {

	@RequestMapping("yet")
	public String yet() {
		return "yet";
	}
}
