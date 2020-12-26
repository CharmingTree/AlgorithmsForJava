package EffectiveJava.tryWIthResources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLineWithDefault {
	
	static String firstLineOfFile(String path, String defaultVal)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			return br.readLine();
			
		}
		catch (IOException e)
		{
			return defaultVal;
		}
	}

	public void main(String[] args) throws IOException
	{
		String path = args[0];
		System.out.println(firstLineOfFile(path, "Toppy McTopFace"));
	}
}
