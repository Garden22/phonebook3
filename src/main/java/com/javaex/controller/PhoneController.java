package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	
	
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController>list");
		
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		
		model.addAttribute("personList", personList);
		
		return "/WEB-INF/views/list.jsp";
	}
	
	
	@RequestMapping(value="/write2", method={RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company) {
		System.out.println("PhoneController>write2");
		System.out.println("name: " + name + ", hp: " + hp + " company: " + company);
		
		PersonVo personVo = new PersonVo(name, hp, company);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "redirect:./list";
	}
	
	
	@RequestMapping(value="/write", method={RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>write");
		System.out.println("name: " + personVo.getName() + ", hp: " + personVo.getHp() + ", company: " + personVo.getCompany());
						
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "redirect:/list";
	}
	
	
	@RequestMapping(value="/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController>writeForm");
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	
	@RequestMapping(value="/delete/{id}", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable("id") int id) {	
		System.out.println("PhoneController>delete");
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personDelete(id);
		return "redirect:/list";
	}
	
	
	@RequestMapping(value="/modifyForm/{id}", method={RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@PathVariable("id") int id, Model model) {
		System.out.println("PhoneController>modifyForm");
		PhoneDao phoneDao = new PhoneDao();
		PersonVo personVo = phoneDao.getPerson(id);
		model.addAttribute("personVo", personVo);
		
		return "/WEB-INF/views/modifyForm.jsp";
	}
	
	
	@RequestMapping(value="/modify", method={RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>modify");
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(personVo);
		return "redirect:/list";
	}
		
	
	@RequestMapping(value="/test", method={RequestMethod.GET, RequestMethod.POST})
	public String test() {
		System.out.println("PhoneController>test");
		return "/WEB-INF/views/test.jsp";
	}
	
}
