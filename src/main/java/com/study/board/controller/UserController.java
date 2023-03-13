package com.study.board.controller;


import com.study.board.entity.User;
import com.study.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //회원가입 폼
    @GetMapping("/user/signup")
    public String userSignupForm(){
        return "userSignup";
    }

    //회원가입 처리
    @PostMapping("/user/signuppro")
    public String userSignupPro(User user, Model model){

        userService.insertUser(user);

        model.addAttribute("message", "회원가입이 완료되었습니다.");
        model.addAttribute("searchUrl", "/board/list");
        return "message";
    }

    //로그인 폼
    @GetMapping("/user/login")
    public String userLoginForm(){
        return "userlogin";
    }

    //로그인 처리
    @PostMapping("/user/loginpro")
    public  String userLoginPro(User user, Model model){
        User loginUser = userService.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());

        if(loginUser==null){

            model.addAttribute("message", "로그인 실패");
            model.addAttribute("searchUrl", "/user/login");
            return "message";
        }
        else {
            return "redirect:/board/list";
        }
    }

}
