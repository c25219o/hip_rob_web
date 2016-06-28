package jp.co.opst.hip_rob.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import jp.co.opst.hip_rob.service.Seeker;
import jp.co.opst.hip_rob.param.InputWord;
import jp.co.opst.hip_rob.referee.LengthLimitReferee;
import jp.co.opst.hip_rob.util.StringUtil;
import jp.co.opst.util.literal.IntegerUtil;
import jp.co.opst.util.literal.LengthUtil;
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

    @Autowired
    private Seeker seeker;

    @Autowired
    private LengthLimitReferee lengthLimitReferee;

    @RequestMapping("rob/lengthLimit")
    public String lengthLimit() {
        return "limitDecide";
    }

    @RequestMapping("rob/lengthLimit/start")
    public String lengthLimit(@RequestParam String limit, HttpSession session, Model model) {

        if (StringUtil.isEmpty(limit)) {
            limit = "1";
        } else if(IntegerUtil.isNotInteger(limit)) {
            model.addAttribute("errorMessage","すうじをにゅうりょくしてね");
            return "limitDecide";
        }
        int limitInt = Integer.parseInt(limit);
        lengthLimitReferee.setMinLimit(limitInt);
        session.setAttribute("referee", lengthLimitReferee);
        return "lengthLimit";
    }

    @RequestMapping("rob/lengthLimit/do")
    public String exe(@ModelAttribute @Validated InputWord words, BindingResult result, Model model) {

        String current = words.getCurrent();
        String previous = words.getPrevious();

        if (result.hasErrors()) {
            if (LengthUtil.isNotEmpty(previous)) {
                model.addAttribute("computer", previous);
            }
            model.addAttribute("list", lengthLimitReferee.all());
            return "lengthLimit";
        }

        // ユーザ：入力あり、その前のコンピュータの答え：なしの場合、一度リセット
        if (LengthUtil.isNotEmpty(current) && LengthUtil.isEmpty(previous)) {
            lengthLimitReferee.forget();
        }

        // 既出の言葉が出た場合
        if (lengthLimitReferee.alreadyInput(current)) {
            model.addAttribute("list", lengthLimitReferee.all());
            model.addAttribute("message", "さっきでたよ");
            return "lengthLimit";
        }

        if (lengthLimitReferee.lengthInvalid(current)) {
            model.addAttribute("list", lengthLimitReferee.all());
            model.addAttribute("message", "もじすうがたりないよ");
            return "lengthLimit";
        }

        lengthLimitReferee.remember(current);

        List<String> computerWords = seeker.seek(current);
        String validAnswer = lengthLimitReferee.findOkWord(computerWords);

        if (validAnswer != null) {
            lengthLimitReferee.remember(validAnswer);
            model.addAttribute("computer", validAnswer);
            model.addAttribute("list", lengthLimitReferee.all());
        } else {
            lengthLimitReferee.forget();
            model.addAttribute("message", "きみのかち！");
        }
        return "lengthLimit";
    }

    @RequestMapping("rob/lengthLimit/giveup")
    public String giveup(Model model) {
        lengthLimitReferee.forget();
        model.addAttribute("message", "きみのまけ！");
        return "lengthLimit";
    }

}
