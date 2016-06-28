package jp.co.opst.hip_rob.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import jp.co.opst.util.literal.LengthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.opst.hip_rob.service.Seeker;
import jp.co.opst.hip_rob.param.InputWord;
import jp.co.opst.hip_rob.referee.StandardReferee;

@Controller
public class StandardRobController {

    @Autowired
    private StandardReferee standardReferee;

    @Autowired
    private Seeker seeker;

    @RequestMapping("rob/standard")
    public String standard(HttpSession session) {
        session.setAttribute("referee", standardReferee);
        return "standard";
    }

    @RequestMapping("rob/standard/do")
    public String exe(@ModelAttribute @Validated InputWord words, BindingResult result, HttpSession session,
                      Model model) {

        String current = words.getCurrent();
        String previous = words.getPrevious();

        if (result.hasErrors()) {
            if (LengthUtil.isNotEmpty(previous)) {
                model.addAttribute("computer", previous);
             }
            model.addAttribute("list", standardReferee.all());
            return "standard";
        }

        // ユーザ：入力あり、その前のコンピュータの答え：なしの場合、一度リセット
        if (LengthUtil.isNotEmpty(current) && LengthUtil.isEmpty(previous)) {
            standardReferee.forget();
        }

        // 既出の言葉が出た場合
        if (standardReferee.alreadyInput(current)) {
            model.addAttribute("list", standardReferee.all());
            model.addAttribute("message", "さっきでたよ");
            return "standard";
        }

        standardReferee.remember(current);

        List<String> computerWords = seeker.seek(current);
        String validAnswer = standardReferee.findOkWord(computerWords);

        if (validAnswer != null) {
            standardReferee.remember(validAnswer);
            model.addAttribute("computer", validAnswer);
            model.addAttribute("list", standardReferee.all());
        } else {
            standardReferee.forget();
            model.addAttribute("message", "きみのかち！");
        }
        return "standard";
    }

    @RequestMapping("rob/standard/giveup")
    public String giveup(Model model) {
        standardReferee.forget();
        model.addAttribute("message", "きみのまけ！");
        return "standard";
    }
}
