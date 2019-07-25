package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Customer;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerTypeController {
	@Autowired
	private ICustomerService service;

	@RequestMapping("/reg")
	public String showreg(ModelMap map) {
		map.addAttribute("customerType", new Customer());
		return "CustomerRegister";
	}
	//-----------2. saveOrder method data--------------------
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute Customer customerType,ModelMap map) {

		Integer id=service.saveCustomer(customerType);
		String msg="CustomerType '"+id+"' saved successfully";
		map.addAttribute("msg", msg);
		map.addAttribute("customerType",new Customer());
		return "CustomerRegister";
	}
	//---------------fetching all rows from DB and sending to UI------------------

	@RequestMapping("/all")
	public String getAllCustomer(ModelMap map) {
		List<Customer> obs=service.getAllCustomer();
		map.addAttribute("list",obs);
		return "CustomerData";
	}
	//---------------Delete row based on id-------------
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam Integer id,ModelMap map) {
		service.deleteCustomer(id);
		List<Customer>obs=service.getAllCustomer();
		map.addAttribute("list",obs);
		map.addAttribute("msg","customerType '"+id+"' deleted successfully");
		return "CustomerData";
	}
	//-----------------------EDIT DB------------------
	@RequestMapping("/edit")
	public String showedit(@RequestParam Integer id,ModelMap map) {
		Customer c=service.getOneCustomer(id);
		map.addAttribute("customerType",c);
		return "CustomerEdit";
	}
	//-----------------------UPDATE DB------------------------
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute Customer customerType,ModelMap map) {
		service.updateCustomer(customerType);
		List<Customer> obs=service.getAllCustomer();
		map.addAttribute("list",obs);
		map.addAttribute("msg","CustomerType '"+customerType.getId()+"' updated!!");
		return "CustomerData";

	}
}
