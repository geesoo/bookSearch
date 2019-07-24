package com.geesoo.bookSearch.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.geesoo.bookSearch.account.dto.Account;
import com.geesoo.bookSearch.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute("registAccount") Account account, BindingResult bindingResult,Model model) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		mav.clear();
		
		//account.setRole("USER");
		System.out.println("account Id : "+ account.getUserName());
		System.out.println("account Pw : "+ account.getPassWord());
		accountService.save(account);
		mav.setViewName("login");
		//rttr.addFlashAttribute("msg", "success");
		return mav;
	}
	
	
	
}
