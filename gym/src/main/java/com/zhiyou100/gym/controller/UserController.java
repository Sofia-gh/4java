package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.IRoleService;
import com.zhiyou100.gym.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sofia
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("logout")
	public String logout(){
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "redirect:/login.html";
	}

	@RequestMapping("login")
	public String login(Model model, User user){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(),user.getPassword());
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg",e.getMessage());
			return "forward:/login.html";
		}
		
		return "redirect:/index";
	}

	@RequiresPermissions("user:select")
	@RequestMapping("show")
	public String show(Model model,Integer page){
		int currentPage = userService.findCurrentPage(page);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("users", userService.findByPage(currentPage));
		model.addAttribute("mPage",userService.findMaxPage());
		return "user/show";
	}

	@RequiresPermissions("user:insert")
	@RequestMapping("add")
	public String add(Model model){
		model.addAttribute("roles",roleService.findAll());
		return "user/add";
	}

	@RequiresPermissions("user:insert")
	@RequestMapping("insert")
	public String insert(User user){
		userService.insert(user);
		return "redirect:show";
	}

	@RequiresPermissions("user:update")
	@RequestMapping("edit")
	public String edit(Integer id,Model model){
		model.addAttribute("roles",roleService.findAll());
		model.addAttribute("user", userService.findById(id));
		return "user/edit";
	}

	@RequiresPermissions("user:update")
	@RequestMapping("update")
	public String update(User user){
		userService.update(user);
		return "redirect:show";
	}

	@RequiresPermissions("user:delete")
	@RequestMapping("delete")
	public String delete(User user){
		userService.delete(user);
		return "redirect:show";
	}
}
