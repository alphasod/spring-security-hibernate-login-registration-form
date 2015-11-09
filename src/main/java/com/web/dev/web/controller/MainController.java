package com.web.dev.web.controller;

import com.web.dev.users.model.User;
import com.web.dev.users.service.CreateUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Resource(name = "CreateUserService")
	public CreateUserService service;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		return model;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("users");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/create-user",method = RequestMethod.GET)
	public ModelAndView createUserGet() {
		ModelAndView model = new ModelAndView();
		model.setViewName("create-user");
		return model;
	}

	@RequestMapping(value = "/create-user", method = RequestMethod.POST)
	public ModelAndView createUserPost(@ModelAttribute("user") User user) {
		ModelAndView model = new ModelAndView();
			try {
				service.createUser(user);
				model.setViewName("login");
			}
			catch(ConstraintViolationException ex){
				model.addObject("error", "This name is already used ");
				model.setViewName("create-user");
			}
		return model;
	}

	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);
		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}
		return error;
	}
}