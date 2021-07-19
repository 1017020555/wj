package com.lc.wj.controller;

import com.lc.wj.pojo.User;
import com.lc.wj.result.ResultInfo;
import com.lc.wj.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @ResponseBody
    @PostMapping("/api/login")
    public ResultInfo login(@RequestBody User user, HttpSession session) {

        ResultInfo resultInf = new ResultInfo();
        try {
            String username = user.getUsername();
            username = HtmlUtils.htmlEscape(username);

            User user1 = userService.getUserByUsernameAndPassword(username, user.getPassword());

            if (null==user1){
                resultInf.setSuccess(false);
                resultInf.setMessage("false");
            }else {
                session.setAttribute("user",user);
                resultInf.setValue(user1);
                resultInf.setSuccess(true);
                resultInf.setMessage("ttrue");
            }

        } catch (Exception e) {
            resultInf.setSuccess(false);
            resultInf.setMessage("Login {} "+e.getMessage());
        }

        return resultInf;
    }

}
