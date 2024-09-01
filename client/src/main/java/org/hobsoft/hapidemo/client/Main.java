package org.hobsoft.hapidemo.client;

public final class Main
{
	private Main()
	{
		throw new AssertionError();
	}
	
	public static void main(String[] args)
	{
		var client = new Client("http://127.0.0.1:8080");
		var recipe = client.get();
		
		var out = System.out;
		out.println(recipe);
	}
}
