package br.com.llongo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.llongo.persistence.entities.Task;
public interface TaskRepository extends JpaRepository<Task, Integer>{



	@Override
	@Query("SELECT x FROM Task x where  x.id = :id")
	public Task findOne(@Param("id") Integer id);


	@Override
	public Task save(Task task);
	
}
