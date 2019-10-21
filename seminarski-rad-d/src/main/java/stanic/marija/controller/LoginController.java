package stanic.marija.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import stanic.marija.security.UserDetailsServiceImpl;

@RestController
public class LoginController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(path="/user-login", method = RequestMethod.GET)
	public UserDetails user(Principal user){
		return userDetailsService.loadUserByUsername(user.getName());
	}	
}
