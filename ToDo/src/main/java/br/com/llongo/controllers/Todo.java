package br.com.llongo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.llongo.persistence.entities.Task;
import br.com.llongo.persistence.repository.TaskRepository;

@Controller
@RequestMapping("/todo")
public class Todo {
	private TaskRepository taskRepository;
	@Autowired
	public Todo(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("tasks",taskRepository.findAll());
		return "todo";
		
	}
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public String create(HttpServletRequest request,Model model,@RequestParam String name,@RequestParam String description) {
		Task task = new Task(null, name,description);
		taskRepository.save(task);
		
		model.addAttribute("msg","Task Created!");
		model.addAttribute("tasks",taskRepository.findAll());
		return "todo";
		
	}
}
