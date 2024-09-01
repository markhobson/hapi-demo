package org.hobsoft.hapidemo.client;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class RecipeHttpMessageConverter extends AbstractHttpMessageConverter<Recipe>
{
	public RecipeHttpMessageConverter()
	{
		super(new MediaType("text", "html"));
	}
	
	@Override
	protected boolean supports(Class<?> clazz)
	{
		return clazz == Recipe.class;
	}
	
	@Override
	protected Recipe readInternal(Class<? extends Recipe> clazz, HttpInputMessage inputMessage)
		throws IOException, HttpMessageNotReadableException
	{
		var document = Jsoup.parse(inputMessage.getBody(), null, "");
		
		var item = document.select("*[itemscope][itemtype=https://schema.org/Recipe]");
		var name = item.select("*[itemprop=name]").text();
		var ingredients = item.select("*[itemprop=recipeIngredient]").stream().map(Element::text).toList();
		var instructions = item.select("*[itemprop=recipeInstructions]").text();
		
		return new Recipe(name, ingredients, instructions);
	}
	
	@Override
	protected void writeInternal(Recipe recipe, HttpOutputMessage outputMessage)
		throws IOException, HttpMessageNotWritableException
	{
		throw new HttpMessageNotWritableException("Recipe not writable");
	}
}
