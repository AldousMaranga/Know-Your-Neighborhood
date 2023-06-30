package com.api.KnowYourNeighborhood.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.KnowYourNeighborhood.entity.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MessageService {

	private static final String HOOKS_URL = "https://hooks.slack.com/services/%s";

	public void sendMsg(String username, Message message) throws JsonProcessingException {

		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("Abam", "T059P1R76JV/B059VEYA3HA/s0b4qnImttKt3Y1vrgVd2JyD");

		String userId = mapping.get(username);
		System.out.println("username: " + userId);
		System.out.println(HOOKS_URL);

		String userWebhookUrl = String.format(HOOKS_URL, userId);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ObjectMapper objectMapper = new ObjectMapper();
		String messageJson = objectMapper.writeValueAsString(message);
		HttpEntity<String> entity = new HttpEntity<>(messageJson, headers);
		System.out.println(userWebhookUrl);

		restTemplate.exchange("https://hooks.slack.com/services/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",
				HttpMethod.POST, entity, String.class);
	}
}
