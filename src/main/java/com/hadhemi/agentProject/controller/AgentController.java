package com.hadhemi.agentProject.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hadhemi.agentProject.entities.Agent;
import com.hadhemi.agentProject.repositories.AgentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AgentController {

	@Autowired
	private AgentRepository agentRepository;

	@SuppressWarnings("rawtypes")
	@PostMapping("/agent")
	public ResponseEntity addAgent(@RequestBody Agent agentBody) {

		ArrayList<String> status = new ArrayList<>(
				Arrays.asList("active", "disconnected", "pending", "never_connected"));
		Agent agent = agentRepository.findByNameOrId(agentBody.getName(),agentBody.getId());
		if (agent == null) {
			agent = new Agent();
			agent.setId(agentBody.getId());
			agent.setDateAdd(agentBody.getDateAdd());
			agent.setIp(agentBody.getIp());
			agent.setLastKeepAlive(agentBody.getLastKeepAlive());
			agent.setName(agentBody.getName());
			agent.setOs(agentBody.getOs());
			agent.setVersion(agentBody.getVersion());
			if (status.contains(agentBody.getStatus())) {
				agent.setStatus(agentBody.getStatus());
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			agentRepository.save(agent);
			return ok("success");
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/{name}")
	public ResponseEntity putAgent(@PathVariable("name") String name, @RequestBody Agent agentBody) {

		Agent agent = agentRepository.findByName(name);
		if (agent != null) {
			agent.setDateAdd(agentBody.getDateAdd());
			agent.setIp(agentBody.getIp());
			agent.setLastKeepAlive(agentBody.getLastKeepAlive());
			agent.setName(agentBody.getName());
			agent.setOs(agentBody.getOs());
			agent.setVersion(agentBody.getVersion());
			agent.setStatus(agentBody.getStatus());
			agentRepository.save(agent);
			return ok("Updated successfully !");
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/agents")
	public List<Agent> getAgents() {

		return agentRepository.findAll();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteAgent(@PathVariable("id") String id) {

		agentRepository.deleteById(id);
		return ok("This Agent is deleted !");

	}
}
