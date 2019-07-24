package com.geesoo.bookSearch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.geesoo.bookSearch.account.dto.Account;

@RestController
public class ViewController {

	
	@GetMapping("/regist")
    public ModelAndView registration(){
        ModelAndView mav = new ModelAndView();
        mav.clear();
        Account account = new Account();
        mav.addObject("account", account);
        mav.setViewName("regist");
        return mav;
    }
}
