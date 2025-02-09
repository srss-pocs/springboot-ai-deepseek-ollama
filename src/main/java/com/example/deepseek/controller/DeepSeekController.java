package com.example.deepseek.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeepSeekController {

	private final ChatClient chatClient;

	public DeepSeekController(@Qualifier("openAiChatClient") ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@GetMapping("/deepseek/{prompt}")
	public String chat(@PathVariable String prompt) {
		return chatClient.prompt().user(prompt).call().content();
	}
}
