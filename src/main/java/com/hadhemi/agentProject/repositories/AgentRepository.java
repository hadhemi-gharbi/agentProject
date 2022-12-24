package com.hadhemi.agentProject.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hadhemi.agentProject.entities.Agent;

@Repository
public interface AgentRepository extends MongoRepository<Agent, String> {
	Agent findByName(String name);
	Agent findByNameOrId(String name,String id);

}
