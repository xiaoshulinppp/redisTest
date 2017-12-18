package com.liu.redisTest.contorll;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.liu.redisTest.domain.UserVO;
import com.liu.redisTest.domain.person;
import com.liu.redisTest.servcie.PersonService;
import com.liu.redisTest.servcie.UserService;



@Controller
@RequestMapping("/userCtrl")
public class UserCtrl_redis {
    
    @Autowired
    private UserService userService;
     
    UserCtrl_redis(){
    	System.out.println("UserCtrl_redis bean,实例化了");
    }
    
    
    @RequestMapping(value="/userCtrl",method=RequestMethod.GET)
    public String sayHello(){
        //model.addAttribute("msg", "Hello,World!");
    	System.out.println("到controllle");
        return "/redis/login";
    }
    
    @RequestMapping("/hello")
	public ModelAndView index() {
		// 
		ModelAndView mav = new ModelAndView("/redis/login");
		return mav;
	}
    @RequestMapping("/addUser")
    @ResponseBody
    public ModelAndView  addUser( HttpServletRequest request,Model model,  UserVO user){
    	//response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
    	ApplicationContext testContext = new ClassPathXmlApplicationContext("applicationContext.xml");  
		 PersonService personService = (PersonService)testContext.getBean("personService"); 
		 person person2= personService.selectByPrimaryKey(1L);
    	
    	System.out.println(request.getParameter("name"));
    	System.out.println(request.getParameter("password"));
        user.getPassword();

    	request.setAttribute("request", "返回值");//测试request 传志写法是否一样。
    	
        HttpSession session=request.getSession();
    	session.setAttribute("user", person2);//前台显示当前用户信息。
    	
    	model.addAttribute("model", "hellomodel是否乱码");
    	model.addAttribute(user);
    	
    	
        ModelAndView mav = new ModelAndView();  
        mav.setViewName("/redis/login"); //返回的文件名  
          
        mav.addObject("message","hello kitty");  
          
        //List  
        List<String> list = new ArrayList<String>();  
        list.add("java");  
        list.add("c++");  
        list.add("oracle");  
        mav.addObject("bookList", list);  
          
        //Map  
        Map<String,String> map1 = new HashMap<String,String>();  
        map1.put("zhangsan", "北京");  
        map1.put("lisi", "上海");  
        map1.put("wangwu", "深圳");  
        mav.addObject("map",map1);  
        return mav;
       // return map;
    }
    @RequestMapping(value = "/upload.do")  
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
  
        System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
//        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
  
        return "/redis/login";  
    }  
    @RequestMapping("/deleteUser")
    public void deleteUser(UserVO user){
        userService.deleteUser(user);
    }
    
    @RequestMapping("/updateUser")
    public void updateUser(UserVO user){
        userService.updateUser(user);
    }
    
    @ResponseBody
    @RequestMapping("/getUserById")
    public Map<String,Object> getUserById(UserVO user){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("msg",userService.getUserById(4));
        return map;
    }
    
    @ResponseBody
    @RequestMapping("/getUser")
    public Map<String,Object> getUser(UserVO vo){
        Map<String,Object> map = new HashMap<String,Object>();
        Object user = userService.getUser(4);
        map.put("msg",user.toString());
        return map;
    }
    
}