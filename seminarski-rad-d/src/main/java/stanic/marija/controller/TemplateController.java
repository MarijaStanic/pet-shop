package stanic.marija.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {

	@RequestMapping("/login")
	public String getLoginPage() {
		System.out.println("**************Login");
		return "login";
	}

	@RequestMapping("/home")
	public String getHomePage() {
		System.out.println("**************Home");
		return "home";
	}

	@RequestMapping("/users")
	public String getUsersPage() {
		System.out.println("**************Users");
		return "/users/users";
	}
}
