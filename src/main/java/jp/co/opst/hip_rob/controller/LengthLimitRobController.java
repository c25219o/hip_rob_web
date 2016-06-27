package jp.co.opst.hip_rob.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LengthLimitRobController {

    @RequestMapping("rob/lengthLimit")
    public String lengthLimit() {
        return "limitDecide";
    }

    @RequestMapping("rob/lengthLimit/start")
    public String lengthLimit(@RequestParam String limit, HttpSession session) {
        return "lengthLimit";
    }

    @RequestMapping("rob/lengthLimit/do")
    public String exe() {
        return "lengthLimit";
    }

    @RequestMapping("rob/lengthLimit/giveup")
    public String giveup(Model model) {
        model.addAttribute("message", "きみのまけ！");
        return "lengthLimit";
    }

}
