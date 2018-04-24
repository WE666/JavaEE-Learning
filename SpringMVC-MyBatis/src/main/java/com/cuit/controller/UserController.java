package com.cuit.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cuit.model.User;
import com.cuit.service.UserService;
  
  
@Controller  
@RequestMapping("/user")  
public class UserController {  
	private static Logger log=LoggerFactory.getLogger(UserController.class);
	 @Resource  
	 private UserService userService;     
    
	 @RequestMapping(value="/add")
	 public String add(){
	    return "userAdd";
	 }
	 
	 @RequestMapping(value="/addUser")  
	 public String addUser (String userName,String password,Integer age,User user){  
	       user.setUserName(userName);
	       user.setPassword(password);
	       user.setAge(age);
		   userService.insert(user);  
	       return ("redirect:/user/list");  
	 }  
	 
	 @RequestMapping(value="/list")  
	 public String list(HttpServletRequest request,Model model){  
	       List<User> user = this.userService.selectAll();  
	       model.addAttribute("user", user);  
	       return "userList";  
	 } 
	 
	 @RequestMapping(value="/deleteUser",method=RequestMethod.GET)  
	    public String deleteUser(@RequestParam("id") String id,Model model){  
	        int userId = Integer.parseInt(id);  
	        userService.deleteById(userId);   
	        return ("redirect:/user/list");
	    }  
	 
	 @RequestMapping(value="/updateUser",method=RequestMethod.GET)  
	    public String updateUser(@RequestParam("id") String id,Model model){  
	        int userId = Integer.parseInt(id);  
	        User user = this.userService.getUserById(userId);  
	        log.debug(user.toString());
	        model.addAttribute("user", user);    
	        return "userEdit";
	    } 
	 @RequestMapping(value="/doUpadteUser",method=RequestMethod.POST)  
	 public String doUpdateUser (Integer id,String userName,String password,Integer age,User user){ 
		   user.setId(id);
	       user.setUserName(userName);
	       user.setPassword(password);
	       user.setAge(age);
		   userService.updateByPrimaryKey(user);  
	       return ("redirect:/user/list");  
	 }  
	 
    @RequestMapping(value="/showUser",method=RequestMethod.GET)  
    public String toIndex(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.userService.getUserById(userId);  
        log.debug(user.toString());
        model.addAttribute("user", user);  
        return "showUser";  
    }  
    
    @RequestMapping(value="/showUser2",method=RequestMethod.GET)  
    public String toIndex2(@RequestParam("id") String id,Model model){  
        int userId = Integer.parseInt(id);  
        User user = this.userService.getUserById(userId);  
        log.debug(user.toString());
        model.addAttribute("user", user);  
        return "showUser";  
    }  
    
    @RequestMapping(value="/showUser3/{id}",method=RequestMethod.GET)  
    public String toIndex3(@PathVariable("id")String id,Map<String, Object> model){  
        int userId = Integer.parseInt(id);  
        User user = this.userService.getUserById(userId);  
        log.debug(user.toString());
        model.put("user", user);  
        return "showUser";  
    }  
    
    @RequestMapping(value="/{id}",method=RequestMethod.GET)  
    public @ResponseBody User getUserInJson(@PathVariable String id,Map<String, Object> model){  
        int userId = Integer.parseInt(id);  
        User user = this.userService.getUserById(userId);  
        log.info(user.toString());
        return user;  
    }  
    
    @RequestMapping(value="/jsontype/{id}",method=RequestMethod.GET)  
    public ResponseEntity<User>  getUserInJson2(@PathVariable String id,Map<String, Object> model){  
        int userId = Integer.parseInt(id);  
        User user = this.userService.getUserById(userId);  
        log.info(user.toString());
        return new ResponseEntity<User>(user,HttpStatus.OK);  
    } 
    
    @RequestMapping(value="/upload")
    public String showUploadPage(){
    	return "upload/file";
    }
    
    @RequestMapping(value="/doUpload",method=RequestMethod.POST)
    public String doUploadFile(@RequestParam("file")MultipartFile file) throws IOException{
    	if (!file.isEmpty()) {
			log.info("Process file:{}",file.getOriginalFilename());
		}
    	FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:\\upload",System.currentTimeMillis()+file.getOriginalFilename()));
    	return "index";
    }
}  