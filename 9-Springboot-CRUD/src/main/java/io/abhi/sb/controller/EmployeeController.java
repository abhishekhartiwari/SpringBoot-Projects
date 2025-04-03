package io.abhi.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.abhi.sb.model.Employee;
import io.abhi.sb.service.EmployeeService;

@Controller
public class EmployeeController {
	
	
	
	@Autowired
	private EmployeeService employeeService;
	
	// display list of employees
	
	@GetMapping("/")
	public String ViewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
		
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model mode) {
		//create model attribute to bind from data
		Employee emp = new Employee();
		mode.addAttribute("employee", emp);
		return "new_employee";
		
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		
		//save emp to db
		employeeService.saveEmployee(emp);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
		//get employee from service
		Employee employee =employeeService.getEmployeeById(id);
		
		//set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id) {
		
		//deleted method from service
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}

}
