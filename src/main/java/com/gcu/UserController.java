package com.gcu;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.UsersBusinessInterface;
import com.gcu.business.UsersBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.RegistrationModel;
import com.gcu.model.SearchModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/")
public class UserController 
{
	@Autowired
	private UsersBusinessInterface service;
	
	@GetMapping("/home")
	public String homeDisplay()
	{
		return "home";
	}
	
	@GetMapping("/register")
	public String registerDisplay(Model model)
	{
		//Display register screen
		model.addAttribute("title", "Registration");
		model.addAttribute("registrationModel", new RegistrationModel());
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(@Valid RegistrationModel registrationModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Registration");
			return "register";
		}
		UserModel user = new UserModel(0, registrationModel.getFirstName(), registrationModel.getLastName(), registrationModel.getEmail(),
				registrationModel.getPhoneNumber(), registrationModel.getUsername(), registrationModel.getPassword());
		
		if(service.addUser(user) > 0)
		{
			model.addAttribute("registrationModel", registrationModel);
			
			return "registerSuccess";
		}
		else
		{
			return "register";
		}
		
	}
	
	@GetMapping("/login")
	public String loginDisplay(Model model)
	{
		//Display Login form
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel,  BindingResult bindingResult, Model model)
	{
		//Basic data validation
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		if(service.login(loginModel))
		{
			model.addAttribute("model", loginModel);
			return "loginSuccess";
		}
		else
		{
			//Failed login, redirect back to login page
			return "login";
		}
	}
	
	@GetMapping("/userAdmin")
	public String userAdminView(Model model)
	{
		List<UserModel> users = service.getAllUsers();
		model.addAttribute("title", "User Admin");
		model.addAttribute("users", users);
		
		return "userAdmin";
	}
	
	@GetMapping("/searchUsers")
	public String searchUserDisplay(Model model)
	{
		model.addAttribute("title", "Search for Users");
		model.addAttribute("searchUserModel", new SearchModel());
		return "searchUsers";
	}
	
	@PostMapping("/userSearchFirst")
	public String searchByFirst(@Valid SearchModel searchModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Search for Users");
			return "searchUsers";
		}
		List<UserModel> users = service.searchByFirstName(searchModel.getSearchTerm());
		model.addAttribute("title", "Search for User by First Name");
		model.addAttribute("searchModel", searchModel);
		model.addAttribute("users", users);
		return "userSearchResults";
	}
	
	@PostMapping("/userSearchLast")
	public String searchByLast(@Valid SearchModel searchModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Search for Users");
			return "searchUsers";
		}
		List<UserModel> users = service.searchByLastName(searchModel.getSearchTerm());
		model.addAttribute("title", "Search for User by Last Name");
		model.addAttribute("searchModel", searchModel);
		model.addAttribute("users", users);
		return "userSearchResults";
	}
	
	@PostMapping("/userSearchUsername")
	public String searchByUsername(@Valid SearchModel searchModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Search for Users");
			return "searchUsers";
		}
		List<UserModel> users = service.searchByUsername(searchModel.getSearchTerm());
		model.addAttribute("title", "Search for User by Username");
		model.addAttribute("searchModel", searchModel);
		model.addAttribute("users", users);
		return "userSearchResults";
	}
	
	@GetMapping("/updateUser")
	public String updateUserDisplay(UserModel userModel, Model model)
	{
		model.addAttribute("title", "Edit User");
		model.addAttribute("userModel", userModel);
		return "editUser";
	}
	
	@PostMapping("/doUpdateUser")
	public String updateUser(@Valid UserModel userModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "User Admin");
			return "userAdmin";
		}
		service.updateUser(userModel.getId(), userModel);
		List<UserModel> users = service.getAllUsers();
		model.addAttribute("title", "User Admin");
		model.addAttribute("users", users);
		return "userAdmin";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(@Valid UserModel userModel, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "User Admin");
			return "userAdmin";
		}
		service.deleteUser(userModel.getId());
		List<UserModel> users = service.getAllUsers();
		model.addAttribute("title", "User Admin");
		model.addAttribute("users", users);
		return "userAdmin";
	}
}
