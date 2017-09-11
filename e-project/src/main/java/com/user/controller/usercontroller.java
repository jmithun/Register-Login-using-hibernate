package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.DAO.UserDAO;
import com.user.entity.User;

@Controller
public class usercontroller {
	@Autowired
	UserDAO userdao;

	@RequestMapping(value="register", method=RequestMethod.GET)
	public ModelAndView sendregister(@ModelAttribute("user")User user)
	{
		ModelAndView mv=new ModelAndView("RegisterPage");
		return mv;
	}
	
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView getUser(User user)
	{
		
		userdao.adduser(user);
		ModelAndView mv=new ModelAndView("loginpage","user",new User());
		return mv;		
		
	}

}
