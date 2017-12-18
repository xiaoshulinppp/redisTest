package com.liu.redisTest.contorll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.liu.redisTest.servcie.UserService;
@Controller
public class helloContorll {
	
	    @Autowired
	    private UserService userService;
	     
	    helloContorll(){
	    	System.out.println("helloContorll bean,实例化了");
	    }
	    
	    
	    @RequestMapping(value="/userCtrl",method=RequestMethod.GET)
	    public String sayHello(){
	        //model.addAttribute("msg", "Hello,World!");
	    	System.out.println("到controllle");
	        return "redis/login";
	    }
	    
	    @RequestMapping("/hello")
		public ModelAndView index() {
			// 
			ModelAndView mav = new ModelAndView("redis/login");
			return mav;
		}
	    @RequestMapping("hello3")
		public ModelAndView index2() {
			// 
			ModelAndView mav = new ModelAndView("redis/login");
			return mav;
		}
}
