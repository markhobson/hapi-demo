package org.hobsoft.hapidemo.client;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.web.client.RestClient;

public class Client
{
	private final RestClient restClient;
	
	public Client(String baseUrl)
	{
		this.restClient = RestClient.builder().baseUrl(baseUrl).build();
	}
	
	public Recipe get()
	{
		var body = this.restClient.get().uri("/").retrieve().body(String.class);
		
		var document = Jsoup.parse(body);
		var name = document.selectFirst("*[itemprop=name]").text();
		var ingredients = document.select("*[itemprop=recipeIngredient]").stream().map(Element::text).toList();
		var instructions = document.selectFirst("*[itemprop=recipeInstructions]").text();
		
		return new Recipe(name, ingredients, instructions);
	}
}
