package com.lc.wj.controller;

import com.lc.wj.pojo.User;
import com.lc.wj.result.ResultInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {

    @CrossOrigin
    @ResponseBody
    @PostMapping("/api/login")
    public ResultInfo login(@RequestBody User user) {

        ResultInfo resultInf = new ResultInfo();
        try {
            String username = user.getUsername();
            username = HtmlUtils.htmlEscape(username);

            if ("admin".equals(username) && "123".equals(user.getPassword())) {

                System.out.println(username + "  -  " + user.getPassword());
                resultInf.setSuccess(true);
                resultInf.setMessage("ttrue");
            } else {
                resultInf.setSuccess(false);
                resultInf.setMessage("false");
            }
        } catch (Exception e) {
            resultInf.setSuccess(false);
            resultInf.setMessage("Login {} "+e.getMessage());
        }

        return resultInf;
    }

}
