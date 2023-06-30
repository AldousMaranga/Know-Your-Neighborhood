package com.api.KnowYourNeighborhood.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.KnowYourNeighborhood.entity.Message;
import com.api.KnowYourNeighborhood.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class MessageController {
	private final MessageService messageService;
	
	public MessageController (MessageService messageService) {
		this.messageService = messageService;
	}
	
	@PostMapping(path ="/messages/{username}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void sendMessage(@PathVariable String username, @RequestBody Message message) throws JsonProcessingException {
		System.out.println(username);
		System.out.println(message.getText());
		messageService.sendMsg(username,message);
	}
}
