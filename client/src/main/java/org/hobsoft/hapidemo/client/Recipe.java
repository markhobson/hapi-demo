package org.hobsoft.hapidemo.client;

import java.util.List;

public record Recipe(String name, List<String> recipeIngredients, String recipeInstructions)
{
}
