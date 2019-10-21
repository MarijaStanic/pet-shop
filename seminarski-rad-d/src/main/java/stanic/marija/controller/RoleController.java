package stanic.marija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stanic.marija.model.Role;
import stanic.marija.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ResponseEntity<List<Role>> getAllRoles(){
		List<Role> roles = roleService.getRoles();
		if (roles.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	
}
