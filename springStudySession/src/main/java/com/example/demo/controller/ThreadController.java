package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.form.ThreadForm;
import com.example.demo.service.ThreadService;

@Controller
public class ThreadController {
	@Autowired
	ThreadService service;

	@RequestMapping("/init")
	public String init() {
		return "/init.html";
	}
	// 掲示板の初期画面
	@RequestMapping("/view")
	public ModelAndView view(@RequestParam(value="page", defaultValue="0") int pageNum) {
		return new ModelAndView("/view").addObject("entityList", service.getEntity(pageNum));
	}
	@PostMapping(value = "/insert")
	public ModelAndView insert(ThreadForm form) {
		service.insert(form);
		return new ModelAndView("redirect:/view");
	}
	@GetMapping(value = "/edit")
	public ModelAndView edit(@RequestParam("id") Integer id) {
		return new ModelAndView("/edit").addObject("thread", service.getOne(id));
	}
	@PostMapping(value = "/update")
	public ModelAndView update(ThreadForm form) {
		service.update(form);
		return new ModelAndView("redirect:/view");
	}
	@PostMapping(value = "/delete")
	public ModelAndView delete(@RequestParam("id") Integer id) {
		service.delete(id);
		return new ModelAndView("redirect:/view");
	}
}
