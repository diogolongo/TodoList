package br.com.llongo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.llongo.persistence.entities.Task;
import br.com.llongo.persistence.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class Tasks {

	private TaskRepository taskRepository;

	@Autowired
	public Tasks(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getAllTasks() {
		List<Task> findAll = taskRepository.findAll();
		return findAll;
	}

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Task getTask(@PathVariable Integer id) {
    	Task one = taskRepository.findOne(id);
    	return one;
    }
	
	@RequestMapping(method = RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Task> creatTask(@RequestBody Task task, UriComponentsBuilder builder){
		Task save = taskRepository.save(task);
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(
                builder.path("/aggregators/orders/{id}")
                        .buildAndExpand(save.getId().toString()).toUri());
        return new ResponseEntity<Task>(save, headers, HttpStatus.CREATED);
	}
}
