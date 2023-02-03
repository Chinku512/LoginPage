package com.example.ZZlogin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ZZlogin.Entity.User;
import com.example.ZZlogin.Repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showReg")
	public String showReg() {
		return "register";
	}
	@RequestMapping("/saveReg")
	public String showReg(@ModelAttribute("user")User user) {
		userRepo.save(user);
		return "login";
	}
	@RequestMapping("/loginPage")
	public String verifyLogin(@RequestParam("email") String email,@RequestParam("password")String password, ModelMap model) {
		User user = userRepo.findByEmail(email);
			if(user!=null) {
				if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
					return "welcome";
				}else {
					model.addAttribute("error", "Invalid Username/password");
					return "register";
				}
			}else {
				model.addAttribute("error", "Invalid Username/password");
				return "register";
			}
	}
}
