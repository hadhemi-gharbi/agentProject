package com.hadhemi.agentProject.entities;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Agent")
public class Agent {
	
	private String os;
	private String lastKeepAlive;
	private String dateAdd;
	private String ip;
	private String name;
	private String id;
	private String version;
	private String status;
	
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getLastKeepAlive() {
		return lastKeepAlive;
	}
	public void setLastKeepAlive(String lastKeepAlive) {
		this.lastKeepAlive = lastKeepAlive;
	}
	public String getDateAdd() {
		return dateAdd;
	}
	public void setDateAdd(String dateAdd) {
		this.dateAdd = dateAdd;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
