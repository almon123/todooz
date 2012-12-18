package fr.todooz.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.todooz.domain.Task;
import fr.todooz.service.TaskService;

@Controller
public class IndexController {
	  @Inject
	  private TaskService taskService;

	  @RequestMapping({ "/", "/index" })
	  public String index(Model model) {
	    model.addAttribute("tasks", taskService.findAll());

	    return "index";
	  }
	  
	 @RequestMapping("/search")
	  public String search(String query, Model model) {
	    model.addAttribute("tasks", taskService.findByQuery(query));
	    return "index";
	  }
	  
	  @PostConstruct
	  public void bootstrap() {
		  if (taskService.count() == 0) {
			    Date now = new Date();
			    
			    Task task1 = new Task();
			    task1.setCreatedAt(now);
			    task1.setDate(now);
			    task1.setId((long) 1);
			    task1.setTags("aaaaa");
			    task1.setText("aaaaaaaaaaaaaaaaaaaaaaaa");
			    task1.setTitle("aaa");
			    
			    Task task2 = new Task();
			    task2.setCreatedAt(now);
			    task2.setDate(now);
			    task2.setId((long) 2);
			    task2.setTags("bbbbb");
			    task2.setText("bbbbbbbbbbbbbbbbbbbbbbbb");
			    task2.setTitle("bbb");
			    
			    Task task3 = new Task();
			    task3.setCreatedAt(now);
			    task3.setDate(now);
			    task3.setId((long) 3);
			    task3.setTags("aaaaa");
			    task3.setText("ccccccccccccccccccccccc");
			    task3.setTitle("ccc");
			    
			    taskService.save(task1);
			    taskService.save(task2);
			    taskService.save(task3);
			   
			    
			}

	  }
	  
	  
	}






