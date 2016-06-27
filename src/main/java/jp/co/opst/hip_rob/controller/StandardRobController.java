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

import jp.co.opst.hip_rob.Seeker;
import jp.co.opst.hip_rob.param.InputWord;
import jp.co.opst.hip_rob.referee.StandardReferee;
import jp.co.opst.hip_rob.util.StringUtil;

@Controller
public class StandardRobController {

    private StandardReferee referee;

    @Autowired
    private Seeker seeker;

    @RequestMapping("rob/standard")
    public String standard(HttpSession session) {
        referee = new StandardReferee();
        session.setAttribute("referee", referee);
        return "standard";
    }

    @RequestMapping("rob/standard/do")
    public String exe(@ModelAttribute @Validated InputWord words, BindingResult result, HttpSession session,
                      Model model) {

        if (result.hasErrors()) {
            if (!StringUtil.isEmpty(words.getPrevious())) {
                model.addAttribute("computer", words.getPrevious());
            }
            model.addAttribute("list", referee.all());
            return "standard";
        }

        String current = words.getCurrent();
        if (referee.alreadyInput(current)) {
            model.addAttribute("list", referee.all());
            model.addAttribute("message", "さっきでたよ");
            return "standard";
        }

        if (seeker.seek(current)) {
            List<String> computerWords = seeker.get();
            String validAnswer = null;
            for (String str : computerWords) {
                if (!referee.alreadyInput(str)) {
                    validAnswer = str;
                }
            }
            if (validAnswer != null) {
                referee.remember(current);
                referee.remember(validAnswer);
                model.addAttribute("computer", validAnswer);
                model.addAttribute("list", referee.all());
                return "standard";
            }
        }

        referee.forget();
        model.addAttribute("message", "きみのかち！");
        return "standard";
    }

    @RequestMapping("rob/standard/giveup")
    public String giveup(Model model) {
        referee.forget();
        model.addAttribute("message", "きみのまけ！");
        return "standard";
    }
}
