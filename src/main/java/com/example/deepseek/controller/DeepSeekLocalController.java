package com.example.deepseek.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekLocalController {

	private final ChatClient chatClient;

	public DeepSeekLocalController(@Qualifier("ollamaChatClient") ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@GetMapping("/localdeepseek/{prompt}")
	public String chat(@PathVariable String prompt) {
		return chatClient.prompt().user(prompt).call().content();
	}
}
