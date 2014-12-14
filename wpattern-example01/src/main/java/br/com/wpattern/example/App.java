package br.com.wpattern.example;

import org.apache.log4j.Logger;

public class App 
{
	private static final Logger logger = Logger.getLogger(App.class);

	public static void main( String[] args )
	{
		logger.info("Example 01.");

		ReflectionClass reflectionClass = new ReflectionClass();

		reflectionClass.invokeNested();
	}
}
