package com.project.SportyShoes.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.project.SportyShoes.entity.UserDetails;
import com.project.SportyShoes.service.UserDetailsService;
@Controller
public class UserDetailsController {
@Autowired
UserDetailsService userservice;
//@GetMapping("/list")
//public List<UserDetails> getUserDetails()
//{
//List<UserDetails> listuser = new ArrayList<UserDetails>();
//listuser= userservice.getUsers();
// return listuser;
//}
@GetMapping("insert")
public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
	String username = req.getParameter("username");
	String emailId = req.getParameter("emailId");
	String phone = req.getParameter("phone");
	ModelAndView mv=new ModelAndView();
	UserDetails u = new UserDetails();
	u.setUsername(username);
	u.setEmailId(emailId);
	u.setPhone(phone);
	UserDetails ud = userservice.insert(u);
	if(ud!=null)
	{
		mv.setViewName("status");
	}
	return mv;
}
@GetMapping("/index")
public String viewUserDetails(Model model)
{
List<UserDetails> listUsers= userservice.listAll();
System.out.println("listUsers" + listUsers);
model.addAttribute("listUsers",listUsers);
return "/index";
}
// @GetMapping("/find")
// public List<UserDetails> findusername(@RequestParam("username") String username)
// {
// List<UserDetails> searchuser =new ArrayList<UserDetails>();
// searchuser = userservice.get(username);
// System.out.println("user"+ searchuser);
// return searchuser;
// }
@GetMapping("/user/{username}")
public String findUserName(@PathVariable(name="username")String username)
{
System.out.println("i am here");
ModelAndView mav = new ModelAndView("find");
List<UserDetails> userdetails=userservice.get(username);
mav.addObject("userdetails", userdetails);
return "finduser";
}
}
