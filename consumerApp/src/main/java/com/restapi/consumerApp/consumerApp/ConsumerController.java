package com.restapi.consumerApp.consumerApp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ConsumerController {
	@Autowired
	RestTemplate rt;
	final String url="http://localhost:8080/employees";

	@RequestMapping("/home")
	public ModelAndView viewHome()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping("/showAll")
	public ModelAndView fetchAll()
	{
		List<Employee> obj=Arrays.asList(rt.getForObject(url, Employee[].class));
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList", obj);
		mv.setViewName("employeeDetails");
		return mv;
	}
	@RequestMapping("/showOnePage")
	public ModelAndView showOnePage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("showOnePage");
		return mv;
	}
	@RequestMapping("/showOne")
	public ModelAndView fetchOne(HttpServletRequest request)
	{
		String id = request.getParameter("Id");
		Employee obj = rt.getForObject(url+"/" + id,Employee.class);
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", obj);
		mv.setViewName("singleEmployeeDetails");
		return mv;
	}
	@RequestMapping("/createOnePage")
	public ModelAndView createOnePage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("createOnePage");
		return mv;
	}
	@RequestMapping(value="/createOne",method = RequestMethod.POST)
	public ModelAndView createOne(@ModelAttribute ("employee") Employee employee)
	{
		Employee obj=rt.postForObject(url,employee, Employee.class);
		ModelAndView mv=new ModelAndView();
		mv.addObject("employee", obj);
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping("/deleteOnePage")
	public ModelAndView deleteOnePage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("deleteOnePage");
		return mv;
	}
	@RequestMapping(value = "/deleteOne")
	public ModelAndView deleteOne(HttpServletRequest request)
	{
		String id = request.getParameter("Id");
		rt.delete(url+"/" + id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", null);
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping("/updateOnePage")
	public ModelAndView updateOnePage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("updateOnePage");
		return mv;
	}
	@RequestMapping(value="/updateOne")
	public ModelAndView updateOne(@ModelAttribute ("employee") Employee employee)
	{
		rt.put(url+"/"+employee.getEmployeeId(),employee);
		ModelAndView mv=new ModelAndView();
		mv.addObject("employee", null);
		mv.setViewName("home");
		return mv;
	}
}
