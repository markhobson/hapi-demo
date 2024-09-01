package org.hobsoft.hapidemo.client;

import org.springframework.web.client.RestClient;

public class Client
{
	private final RestClient restClient;
	
	public Client(String baseUrl)
	{
		this.restClient = RestClient.builder()
			.baseUrl(baseUrl)
			.messageConverters(messageConverters -> messageConverters.add(new RecipeHttpMessageConverter()))
			.build();
	}
	
	public Recipe get()
	{
		return this.restClient.get().uri("/").retrieve().body(Recipe.class);
	}
}
