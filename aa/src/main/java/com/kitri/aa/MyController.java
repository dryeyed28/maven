package com.kitri.aa;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	//의존성 주입
	@Resource(name="memService")
	MemberDAO daoService;

	public void setDaoService(MemberDAO daoService) {
		this.daoService = daoService;
	}

	@RequestMapping(value = "/form.do")
	public String form() {
		return "form";
	}

	@RequestMapping(value = "/add.do")
	public String add(@ModelAttribute("xxx") Member m) { 
		daoService.insertMember(m);
		return "add_result";
	}

	@RequestMapping(value = "/list.do")
	public ModelAndView list() {
		ArrayList<Member> datas = 
		(ArrayList<Member>) daoService.getMembers();
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("datas", datas);
		return mav;
	}

	@RequestMapping(value = "/search.do")
	public ModelAndView search(
			@RequestParam(value = "name", required = true) String name) {
		ModelAndView mav = new ModelAndView("editForm"); 
		Member m = daoService.getMember(name);
		mav.addObject("m", m);
		return mav;
	}

	@RequestMapping(value = "/edit.do")
	public String edit(Member m) {
		daoService.updateMember(m);
		return "redirect:/list.do";
	}

	@RequestMapping(value = "/del.do")
	public String del(@RequestParam(value = "name", 
	required = true) String name) {
		daoService.deleteMember(name);
		return "redirect:/list.do";
	}
}


