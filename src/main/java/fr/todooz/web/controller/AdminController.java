package fr.todooz.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.todooz.domain.Task;
import fr.todooz.service.TaskService;


@Controller
public class AdminController {
	
	
	private TaskService taskService;
	
	@RequestMapping("/add")
	public String add(Model model) {
	    // on injecte une Task vierge dans le mod¨¨le
	    model.addAttribute("task", new Task());

	    return "edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String post(@ModelAttribute Task task, BindingResult result) {
	    if (result.hasErrors()) {
	        return "edit";
	    }

	    taskService.save(task);

	    return "redirect:/";
	}
	
	@InitBinder
	public void initBinder(DataBinder binder) {
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, true));
	   
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
	    model.addAttribute("task", taskService.findById(id));

	    return "edit";
	}

}
