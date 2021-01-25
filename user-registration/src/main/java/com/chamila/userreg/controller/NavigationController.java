package com.chamila.userreg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chamila.userreg.model.Address;
import com.chamila.userreg.model.AuthUser;
import com.chamila.userreg.model.Country;
import com.chamila.userreg.model.State;
import com.chamila.userreg.model.User;
import com.chamila.userreg.service.CountryService;
import com.chamila.userreg.service.UserService;

@Controller
public class NavigationController {
	
	@Autowired
	UserService userService;
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	CountryService countryService;
	
//	@Autowired
//	StateService stateService;
	
	 @PostMapping("/default_success_page")
	    public String getDefaultSuccessPage() {
	       	 
	        return "dashboard";
	    }  

	 
	   @GetMapping("/registration")
	    public String getRegistrationPage(Model model) {
		   List<Country>countryList=new ArrayList<Country>();
		   countryList= countryService.findCountries();
		   
		   List<State>stateList=new ArrayList<State>();
		   stateList= countryService.findStates();
		   //stateList.add(new State("default"));
		   
		   model.addAttribute("states", stateList);

           model.addAttribute("countries", countryList);
		  
		   
	        return "registration";
	    } 
	   
	   
	   @GetMapping("/states")
	    public String getStatesForCountry(Model model,@RequestParam String countryName) {
		   List<State>stateList=new ArrayList<State>();
		   stateList= countryService.findStates(countryName);
		   
		   
		   System.out.println("states list four country->"+countryName);
		   System.out.println("stateList size->"+stateList.size());
		   
		   for (State state : stateList) {
			System.out.println(state.getName());
		}
		   
		   model.addAttribute("states", stateList);
		   
	        return "registration";
	    } 
	   
	   
	   @RequestMapping(value = "/user", method = RequestMethod.POST )
       public String addNewUser(            
                               @RequestParam(value = "name")String name,
                               @RequestParam(value = "country")String country,
                               @RequestParam(value = "state")String state,
                               @RequestParam(value = "address1")String address1,
                               @RequestParam(value = "address2")String address2,
                               @RequestParam(value = "city")String city,
                               @RequestParam(value = "zipcode")int zipcode,
                               @RequestParam(value = "phone")int phone,
                               @RequestParam(value = "email")String email,
                               @RequestParam(value = "password")String password
                                               ){
			
		   User user=new User();
		   Address address=new Address();
		   AuthUser authUser=new AuthUser();
		   
		   address.setAddress1(address1);
		   address.setAddress2(address2);
		   address.setCity(city);
		   address.setZipcode(zipcode);
		   
		   authUser.setEnabled(1);
		   authUser.setUsername(email);
		   authUser.setRole("ROLE_USER");
		   authUser.setPassword( passwordEncoder.encode(password));
		   
		   user.setName(name);
		   user.setCountry(country);
		   user.setState(state);
		   user.setPhone(phone);
		   user.setAddress(address);
		   user.setAuth_user_id(authUser);
		   
		   
		   
		  System.out.println("Saving user-> "+user); 
		  userService.save(user);
		  
		  
		  
		   
		   return "test";
		   
	   }
	   
	   @GetMapping("/test")
	    public String getTestPage() {
	       	 
	        return "test";
	    } 
}
