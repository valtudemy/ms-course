package com.udemy.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.hrworker.entities.Worker;
import com.udemy.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env;

	@Autowired
	private WorkerRepository repository;
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs(){
		return ResponseEntity.noContent().build();
	}
		
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		logger.info("Port = " + env.getProperty("local.server.port"));
		return ResponseEntity.ok(repository.findById(id).get());
	}
	
}