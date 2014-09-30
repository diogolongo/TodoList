package br.com.llongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("/list")
	public String list(ModelMap model) {
//		taskRepository.save(new Task(null, "teste", "testedesc"));
		model.addAttribute("tasks",taskRepository.findAll());
		return "todo";
		
	}

}
